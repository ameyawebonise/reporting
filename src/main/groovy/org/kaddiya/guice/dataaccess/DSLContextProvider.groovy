package org.kaddiya.guice.dataaccess

import com.google.inject.Provider
import groovy.transform.CompileStatic
import org.jooq.ConnectionProvider
import org.jooq.DSLContext
import org.jooq.SQLDialect
import org.jooq.conf.Settings
import org.jooq.exception.DataAccessException
import org.jooq.impl.DSL

import javax.sql.DataSource
import java.sql.Connection

/**
 * Created by Webonise on 20/09/16.
 */
@CompileStatic
class DSLContextProvider implements Provider<DSLContext> {

    private final DataSource dataSource

    private final boolean isReadOnly

    DSLContextProvider(DataSource dataSource, boolean isReadOnly) {
        this.dataSource = dataSource
        this.isReadOnly = isReadOnly
    }

    @Override
    DSLContext get() {
        Settings settings = new Settings().withRenderSchema(false)
        def connProvider = new ConnectionProvider() {
            private volatile Connection conn = null;

            Connection acquire() throws DataAccessException {
                conn = (conn ?: dataSource.connection)
                conn.readOnly = isReadOnly
                return conn
            }

            void release(Connection connection) throws DataAccessException {
                if (!connection) return
                if (connection != conn) throw new DataAccessException("Told to release a connection other than the one we acquired");
                conn.readOnly = true
                conn.close()
                conn = null
            }
        }
        return DSL.using(connProvider, SQLDialect.MYSQL, settings)
    }
}


