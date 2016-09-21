package org.kaddiya.resources.insights

import com.google.inject.Inject
import org.kaddiya.helper.CsvToJsonConverter
import org.kaddiya.services.InsightsService
import org.restlet.resource.Get
import org.restlet.resource.Post
import org.restlet.resource.ServerResource

/**
 * Created by Webonise on 21/09/16.
 */
class InsightResultResource extends ServerResource {

    InsightsService insightsServiceImpl

    @Inject
    public InsightResultResource(InsightsService insightsServiceImpl){
        this.insightsServiceImpl = insightsServiceImpl
    }

    @Post
    public String getInsightResult(){
        int insRprtReqId = Integer.valueOf(getQueryValue("insightId"))
        def insightReportDetailsResult =  insightsServiceImpl.getQueryResult(insRprtReqId)
        return "insightReportDetailsResult as data"
    }
}
