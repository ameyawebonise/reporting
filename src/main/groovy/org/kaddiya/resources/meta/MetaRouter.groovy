package org.kaddiya.resources.meta

import groovy.transform.CompileStatic
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
