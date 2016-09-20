package org.kaddiya.dao;

import org.kaddiya.pojos.InsightsQueryData;
import org.kaddiya.reporting.sql.commons.tables.pojos.InsightsQueries;

import java.util.List;

/**
 * Created by Webonise on 20/09/16.
 */
public interface InsightsDao {

    List<InsightsQueries> getAllInsightsQueries();


    void saveQueryData(InsightsQueryData insightsQueryData);


    //TODO: provide implementaiton of the following
    /*InsightsQueryData getInsightsSqlByQueryId(int queryId);

    boolean removeInsightsSqlByQueryId(int queryId);

    String getQueryResult(String sqlQuery);

    boolean isQueryTitleNotExists(String queryTitle);

    boolean isQueryKeyNotExists(String queryKey);

    void saveOrUpdateInsightReportRequest(InsightReportRequests insightReportRequests);

    InsightReportRequests getInsightReportRequest(int insightRprReqtId);
    */
}
