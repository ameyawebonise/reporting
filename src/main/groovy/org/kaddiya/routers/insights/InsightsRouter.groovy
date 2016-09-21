package org.kaddiya.routers.insights

import org.kaddiya.resources.insights.InsightDetailsResource
import org.kaddiya.resources.insights.InsightsResource
import restling.restlet.RestlingRouter

/**
 * Created by Webonise on 20/09/16.
 */
class InsightsRouter extends RestlingRouter {
    @Override
    void init() throws Exception {
        attach("/", InsightsResource)
        attach("/{insightId}", InsightDetailsResource)
        attach("/{insightId}/result",InsightResultResource)
/*        attach("/query", InsightsQueryResource)
        attach("/query/{queryId}", InsightsQueryResource)
        attach("/queryTitle", InsightsQueryTitleResource)
        attach("/queryKey", InsightsQueryKeyResource)
        attach("/query/update", InsightsQueryResource)
        attach("/implicitParams", InsightsImplicitParamResource)
        attach("/reportrequests", InsightReportRequestResource)
        attach("/reportresult", InsightsReportsResultsResource)*/
    }
}
