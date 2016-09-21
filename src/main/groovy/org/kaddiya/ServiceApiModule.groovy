package org.kaddiya

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.kaddiya.guice.ServicesModule
import org.kaddiya.guice.dataaccess.DataAccessModule
import org.kaddiya.helper.CsvToJsonConverter
import org.kaddiya.routers.RootRouter
import org.kaddiya.validators.ResultSetValidator
import restling.guice.modules.RestlingApplicationModule

@Slf4j
@CompileStatic
class ServiceApiModule extends RestlingApplicationModule {

    Class<RootRouter> routerClass = RootRouter

    @Override
    void configureCustomBindings() {
        this.install(new ServicesModule())
        this.install(new DataAccessModule())
        bind(ResultSetValidator)
        bind(CsvToJsonConverter)
    }
}
