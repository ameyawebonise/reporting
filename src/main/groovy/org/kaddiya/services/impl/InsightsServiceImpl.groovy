package org.kaddiya.services.impl

import com.google.inject.Inject
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.kaddiya.dao.InsightsDao
import org.kaddiya.pojos.InsightsQueryData
import org.kaddiya.reporting.sql.commons.tables.pojos.InsightsQueries
import org.kaddiya.services.InsightsService
import org.apache.commons.lang3.StringUtils


import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * Created by Webonise on 20/09/16.
 */
@Slf4j
@CompileStatic
class InsightsServiceImpl implements InsightsService {

    private final InsightsDao insightsDaoImpl

    @Inject
    public InsightsServiceImpl(InsightsDao impl) {
        this.insightsDaoImpl = impl
    }

    @Override
    List<InsightsQueries> getAllInsightsQueries() {
        return insightsDaoImpl.getAllInsightsQueries()
    }

    @Override
    void saveAndFlushQueryData(InsightsQueryData insightsQueryData) {
        insightsDaoImpl.saveQueryData(insightsQueryData)
    }

    @Override
    InsightsQueryData getInsightDetailsById(int insightId) {
        return insightsDaoImpl.getInsightsSqlByQueryId(insightId)
    }

    @Override
    String getQueryResult(int insightId, Map<String, String> insightsParamMap) {
        InsightsQueryData insightsQueryData = insightsDaoImpl.getInsightsSqlByQueryId(insightId)
        String query = insightsQueryData.insightQuery.getInsQuery();

        if (insightsQueryData.queryParam) {
            query = setQueryParameterValue(query, insightsParamMap)
        }

      /*  def queryResult = insightsDao.getQueryResult(query)
        log.debug("Query result in CSV format \n ${queryResult}")*/
        return ""
    }

    private String setQueryParameterValue(String sql, Map<String, String> parameterValues) {
        parameterValues.each {
            Matcher matcher = Pattern.compile(":" + it.getKey()).matcher(sql);
            while (matcher.find()) {
                String value = it.getValue()
                if (!StringUtils.isNumeric(value) && value.indexOf("\'") < 0) {
                    value = String.format("%s", value)
                }
                sql = sql.replaceAll(matcher.group(0), value)
            }
        }
        return sql
    }

}
