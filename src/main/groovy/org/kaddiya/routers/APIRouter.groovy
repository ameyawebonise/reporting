package org.kaddiya.routers

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.kaddiya.routers.insights.InsightsRouter
import org.kaddiya.routers.meta.MetaRouter
import restling.restlet.RestlingRouter

/**
 * Created by Webonise on 20/09/16.
 */
@CompileStatic
@Slf4j
class APIRouter extends RestlingRouter {
    @Override
    void init() throws Exception {
        attachSubRouter("/meta", MetaRouter)
        attachSubRouter("/insights",InsightsRouter)
    }
}
