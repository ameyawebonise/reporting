package org.kaddiya.pojos

import groovy.transform.Canonical

/**
 * Created by Webonise on 21/09/16.
 */
@Canonical
class InsightExecutionRequest {
    int queryId
    Map<String, String> params
}
