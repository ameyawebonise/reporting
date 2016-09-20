package org.kaddiya.services.impl

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.kaddiya.reporting.sql.commons.tables.pojos.InsightsQueries
import org.kaddiya.services.InsightsService

/**
 * Created by Webonise on 20/09/16.
 */
@Slf4j
@CompileStatic
class InsightsServiceImpl implements InsightsService {

    @Override
    List<InsightsQueries> getAllInsightsQueries() {
        return Arrays.asList()
    }
}
