package org.kaddiya.dao.impl

import com.google.inject.Inject
import com.google.inject.name.Named
import org.jooq.DSLContext
import org.kaddiya.dao.InsightsDao
import org.kaddiya.reporting.sql.commons.tables.pojos.InsightReportRequests
import org.kaddiya.reporting.sql.commons.tables.pojos.InsightsQueries
import org.kaddiya.validators.ResultSetValidator

/**
 * Created by Webonise on 20/09/16.
 */
class InsightsDaoImpl implements InsightsDao {

    private final DSLContext dslContextReadOnly
    private final ResultSetValidator resultsetValidator

    @Inject
    InsightsDaoImpl(
            @Named("reportingDBDSLContext") DSLContext dslContextReadonly,
            ResultSetValidator resultsetValidator) {
        this.dslContextReadOnly = dslContextReadonly
        this.resultsetValidator = resultsetValidator
    }

    @Override
    List<InsightsQueries> getAllInsightsQueries() {
        return Arrays.asList()
    }

}
