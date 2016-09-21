package org.kaddiya.resources.insights

import com.google.inject.Inject
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.kaddiya.pojos.InsightsQueryData
import org.kaddiya.services.InsightsService
import org.restlet.resource.Get
import org.restlet.resource.ResourceException
import org.restlet.resource.ServerResource

/**
 * Created by Webonise on 21/09/16.
 */
@Slf4j
@CompileStatic
class InsightDetailsResource extends ServerResource {

    final InsightsService insightsServiceImpl

    @Inject
    public InsightDetailsResource(InsightsService impl) {
        this.insightsServiceImpl = impl
    }

    @Get
    InsightsQueryData getInsightDetailsById() {
        int insightId = getAttribute("insightId") as int
        if (!insightId) {
            throw new ResourceException(400, "bad insight ID")
        }

        InsightsQueryData data = insightsServiceImpl.getInsightDetailsById(insightId)
        return data

    }
}
