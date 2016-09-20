package org.kaddiya.routers.meta

import groovy.transform.CompileStatic
import org.kaddiya.resources.meta.PingResource
import restling.restlet.RestlingRouter

/**
 * Router for everything under /meta
 */
@CompileStatic
class MetaRouter extends RestlingRouter {

    @Override
    void init() throws Exception {
        attach("/ping", PingResource)
    }
}
