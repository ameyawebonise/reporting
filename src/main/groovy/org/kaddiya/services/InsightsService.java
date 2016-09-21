package org.kaddiya.services;

import org.kaddiya.pojos.InsightsQueryData;
import org.kaddiya.reporting.sql.commons.tables.pojos.InsightsQueries;

import java.util.List;
import java.util.Map;

/**
 * Created by Webonise on 20/09/16.
 */
public interface InsightsService {
    public List<InsightsQueries> getAllInsightsQueries();

    public void saveAndFlushQueryData(InsightsQueryData data);

    InsightsQueryData getInsightDetailsById(int insightId);

    String getQueryResult(int queryId, Map<String, String> insightsParamMap);
}
