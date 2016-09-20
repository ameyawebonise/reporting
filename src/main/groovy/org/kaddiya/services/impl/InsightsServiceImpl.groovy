package org.kaddiya.services.impl

import com.google.inject.Inject
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.kaddiya.dao.InsightsDao
import org.kaddiya.reporting.sql.commons.tables.pojos.InsightsQueries
import org.kaddiya.services.InsightsService

/**
 * Created by Webonise on 20/09/16.
 */
@Slf4j
@CompileStatic
class InsightsServiceImpl implements InsightsService {

    private final InsightsDao insightsDaoImpl

    @Inject
    public InsightsServiceImpl(InsightsDao impl){
        this.insightsDaoImpl = impl
    }
    @Override
    List<InsightsQueries> getAllInsightsQueries() {
        return insightsDaoImpl.getAllInsightsQueries()
    }
}
