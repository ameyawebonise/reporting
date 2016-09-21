package org.kaddiya.resources.insights

import org.restlet.resource.Get
import org.restlet.resource.ResourceException
import org.restlet.resource.ServerResource

/**
 * Created by Webonise on 21/09/16.
 */
class InsightDetailsResource extends ServerResource {

    @Get
    String getInsightDetailsById(){
        int insightId = getAttribute("insightId") as int
        if(!insightId){
            throw new ResourceException(400,"bad insight ID")
        }
        return "displaying details with id ${insightId}"
    }
}
