package org.kaddiya.guice

import com.google.inject.AbstractModule
import org.kaddiya.services.InsightsService
import org.kaddiya.services.impl.InsightsServiceImpl

/**
 * Created by Webonise on 20/09/16.
 */
class ServicesModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(InsightsService).to(InsightsServiceImpl)
    }
}
