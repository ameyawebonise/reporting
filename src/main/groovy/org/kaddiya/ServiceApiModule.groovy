package org.kaddiya

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.kaddiya.routers.RootRouter
import restling.guice.modules.RestlingApplicationModule

@Slf4j
@CompileStatic
class ServiceApiModule extends RestlingApplicationModule {

    Class<RootRouter> routerClass = RootRouter

    @Override
    void configureCustomBindings() {
    }
}
