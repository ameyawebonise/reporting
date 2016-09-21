package org.kaddiya.resources.insights

import com.google.inject.Inject
import groovy.transform.CompileStatic
import org.kaddiya.pojos.InsightExecutionRequest
import org.kaddiya.services.InsightsService
import org.restlet.resource.Post
import org.restlet.resource.ServerResource

/**
 * Created by Webonise on 21/09/16.
 */
@CompileStatic
class InsightResultResource extends ServerResource {

    InsightsService insightsServiceImpl

    @Inject
    public InsightResultResource(InsightsService insightsServiceImpl) {
        this.insightsServiceImpl = insightsServiceImpl
    }


}
