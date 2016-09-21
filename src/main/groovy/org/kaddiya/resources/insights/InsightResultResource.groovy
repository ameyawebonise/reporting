package org.kaddiya.resources.insights

import com.google.inject.Inject
import org.kaddiya.helper.CsvToJsonConverter
import org.restlet.resource.Get
import org.restlet.resource.Post
import org.restlet.resource.ServerResource

/**
 * Created by Webonise on 21/09/16.
 */
class InsightResultResource extends ServerResource {



    public InsightResultResource(CsvToJsonConverter csvToJsonConverter){
            this.csvToJsonConverter =csvToJsonConverter
    }

    @Post
    public String getInsightResult(){
        int insRprtReqId = Integer.valueOf(getQueryValue("insightId"))
        def insightReportDetails =  insightReportsResultService.getReportResultCSV(authToken, insRprtReqId)
        insightReportDetails.queryResult = new CsvToJsonConverter(insightReportDetails.queryResult).getJson()
        return ""
    }
}
