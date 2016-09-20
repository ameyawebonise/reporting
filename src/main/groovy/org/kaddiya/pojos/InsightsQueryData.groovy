package org.kaddiya.pojos

import groovy.transform.Canonical
import groovy.transform.CompileStatic
import org.kaddiya.reporting.sql.commons.tables.pojos.InsightQueryParams
import org.kaddiya.reporting.sql.commons.tables.pojos.InsightsQueries

/**
 * Created by Webonise on 20/09/16.
 */
@Canonical
@CompileStatic
public class InsightsQueryData {
    InsightsQueries insightQuery
    List<InsightQueryParams> queryParam
}
