package org.kaddiya.resources.insights

import com.google.inject.Inject
import org.kaddiya.pojos.InsightsQueryData
import org.kaddiya.reporting.sql.commons.tables.pojos.InsightsQueries
import org.kaddiya.services.InsightsService
import org.restlet.resource.Get
import org.restlet.resource.Post
import org.restlet.resource.ServerResource

/**
 * Created by Webonise on 20/09/16.
 */
class InsightsResource extends ServerResource {

    final InsightsService insightsServiceImpl

    @Inject
    public InsightsResource(InsightsService impl) {
        this.insightsServiceImpl = impl
    }

    @Get
    public List<InsightsQueries> getAllQueries() {
        return getInsightsServiceImpl().getAllInsightsQueries()
    }

    @Post
    String saveAndFlushQueryData(InsightsQueryData insightsQueryData){
        insightsServiceImpl.saveAndFlushQueryData(insightsQueryData)
        return "done"
    }


}
