package org.kaddiya.dao.impl

import com.google.inject.Inject
import com.google.inject.name.Named
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.jooq.Configuration
import org.jooq.DSLContext
import org.jooq.Record
import org.jooq.TableRecord
import org.jooq.exception.DataAccessException
import org.jooq.impl.DSL
import org.kaddiya.dao.InsightsDao
import org.kaddiya.pojos.InsightsQueryData
import org.kaddiya.reporting.sql.commons.tables.pojos.InsightsQueries
import org.kaddiya.validators.ResultSetValidator
import org.restlet.resource.ResourceException

import static org.kaddiya.reporting.sql.commons.tables.InsightQueryParams.INSIGHT_QUERY_PARAMS
import static org.kaddiya.reporting.sql.commons.tables.InsightsQueries.INSIGHTS_QUERIES

/**
 * Created by Webonise on 20/09/16.
 */
@CompileStatic
@Slf4j
class InsightsDaoImpl implements InsightsDao {

    private final DSLContext reportingDBDSLContext
    private final ResultSetValidator resultsetValidator

    @Inject
    InsightsDaoImpl(
            @Named("reportingDBDSLContext") DSLContext reportingDBDSLContext,
            ResultSetValidator resultsetValidator) {
        this.reportingDBDSLContext = reportingDBDSLContext
        this.resultsetValidator = resultsetValidator
    }

    @Override
    List<InsightsQueries> getAllInsightsQueries() {
        return reportingDBDSLContext.select().from(INSIGHTS_QUERIES).fetch().into(InsightsQueries)
    }

    @Override
    void saveQueryData(InsightsQueryData insightsQueryData) {
        try {
            def queryResult = reportingDBDSLContext.select().from(INSIGHTS_QUERIES).
                    where(INSIGHTS_QUERIES.INS_QUERY_ID.eq(insightsQueryData.insightQuery.insQueryId)).fetch()
            if (queryResult) {
                updateQueryData(queryResult.get(0), insightsQueryData)
            } else {
                save(insightsQueryData)
            }
        } catch (DataAccessException exception) {
            log.error(exception.cause.message)
            throw new ResourceException(409, "duplicate found")
        }
    }


    boolean updateQueryData(Record queryRecord, final InsightsQueryData insightsQueryData) {
        reportingDBDSLContext.transaction { configuration ->
            queryRecord.from(insightsQueryData.insightQuery)
            if (DSL.using(configuration as Configuration)
                    .executeUpdate(queryRecord as TableRecord, INSIGHTS_QUERIES.INS_QUERY_ID.eq(insightsQueryData.insightQuery.insQueryId))) {

                DSL.using(configuration as Configuration).deleteFrom(INSIGHT_QUERY_PARAMS).
                        where(INSIGHT_QUERY_PARAMS.INS_QUERY_ID.eq(insightsQueryData.insightQuery.insQueryId)).execute()

                def insightQueryParams = insightsQueryData.queryParam

                insightQueryParams?.each {
                    it.insQueryId = insightsQueryData.insightQuery.insQueryId
                    def insightQueryParamsRecord = DSL.using(configuration as Configuration).newRecord(INSIGHT_QUERY_PARAMS, it)
                    if (insightQueryParamsRecord.store()) {
                        it.insQryParamId = insightQueryParamsRecord.insQryParamId
                    }
                }
            }
        }
    }

    void save(final InsightsQueryData insightsQueryData) {
        reportingDBDSLContext.transaction { configuration ->
            def insightsQueriesRecord = DSL.using(configuration as Configuration).newRecord(INSIGHTS_QUERIES, insightsQueryData.insightQuery)
            if (insightsQueriesRecord.store()) {
                def insightQueryParams = insightsQueryData.queryParam
                insightsQueryData.insightQuery.insQueryId = insightsQueriesRecord.insQueryId
                insightQueryParams.each {
                    it.insQueryId = insightsQueriesRecord.insQueryId
                    def insightQueryParamsRecord = DSL.using(configuration as Configuration).newRecord(INSIGHT_QUERY_PARAMS, it)
                    if (insightQueryParamsRecord.store()) {
                        it.insQryParamId = insightQueryParamsRecord.insQryParamId
                    }
                }
            }
        }
    }
}
