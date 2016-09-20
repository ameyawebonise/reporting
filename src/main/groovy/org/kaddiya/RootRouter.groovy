package org.kaddiya

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import restling.restlet.RestlingRouter
import org.kaddiya.resources.meta.MetaRouter

@Slf4j
@CompileStatic
class RootRouter extends RestlingRouter {

    @Override
    void init() throws Exception {
        attachSubRouter("/meta", MetaRouter)
    }
}
