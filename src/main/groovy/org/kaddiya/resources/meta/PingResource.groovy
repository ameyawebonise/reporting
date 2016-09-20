package org.kaddiya.resources.meta

import org.restlet.resource.Get
import org.restlet.resource.ServerResource

/**
 * Created by Webonise on 20/09/16.
 */
class PingResource extends ServerResource {

    @Get
    String ping() {
        return "pong"
    }
}
