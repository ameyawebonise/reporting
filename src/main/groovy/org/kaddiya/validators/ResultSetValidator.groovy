package org.kaddiya.validators

import groovy.transform.CompileStatic
import org.jooq.Record
import org.jooq.Result
import org.restlet.resource.ResourceException

/**
 * Created by Webonise on 20/09/16.
 */
@CompileStatic
class ResultSetValidator {

    public <T> List<T> validateResult(Result result, String validationMessage, Class<T> clazz) {
        if (!result) {
            throw new ResourceException(404, "not found")
        }
        return result.into(clazz)
    }

    public <T> T validateResult(Record result, String validationMessage, Class<T> clazz) {
        if (!result) {
            throw new ResourceException(404, "not found")
        }
        return result.into(clazz)
    }
}


