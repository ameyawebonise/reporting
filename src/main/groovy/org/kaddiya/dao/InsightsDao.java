package org.kaddiya.dao;

import org.jooq.Record;
import org.kaddiya.pojos.InsightsQueryData;
import org.kaddiya.reporting.sql.commons.tables.pojos.InsightReportRequests;
import org.kaddiya.reporting.sql.commons.tables.pojos.InsightsQueries;

import java.util.List;

/**
 * Created by Webonise on 20/09/16.
 */
public interface InsightsDao {

   List<InsightsQueries> getAllInsightsQueries();

    //TODO: provide implementaiton of the following

    void saveQueryData(InsightsQueryData insightsQueryData);

    //boolean updateQueryData(Record queryRecord, InsightsQueryData insightsQueryData);
/*
    //InsightsQueryData getInsightsSqlByQueryId(int queryId);

    boolean removeInsightsSqlByQueryId(int queryId);

    String getQueryResult(String sqlQuery);

    boolean isQueryTitleNotExists(String queryTitle);

    boolean isQueryKeyNotExists(String queryKey);

    //

    // void saveAndFlushQueryData(InsightsQueryData insightsQueryData);

    void saveOrUpdateInsightReportRequest(InsightReportRequests insightReportRequests);

    InsightReportRequests getInsightReportRequest(int insightRprReqtId);
    */
}
