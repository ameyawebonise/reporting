package org.kaddiya.guice.dataaccess

import com.google.inject.AbstractModule
import com.google.inject.name.Names
import groovy.transform.CompileStatic
import org.jooq.DSLContext

import javax.naming.InitialContext
import javax.sql.DataSource

/**
 * Created by Webonise on 20/09/16.
 */
@CompileStatic
class DataAccessModule extends AbstractModule {

    static final String REPORTING_DB_JNDI = "java:comp/env/jdbc/reporting-api-db"
    static final String TARGET_DB_JNDI = "java:comp/env/jdbc/target-db"

    @Override
    void configure() {
        def reportingDBDataSource = InitialContext.doLookup(REPORTING_DB_JNDI) as DataSource
        assert reportingDBDataSource: "The datasource can not be null for JNDI ${REPORTING_DB_JNDI}"

        def targetDBDataSource = InitialContext.doLookup(TARGET_DB_JNDI) as DataSource
        assert targetDBDataSource: "The target datasource can not be null for JNDI ${TARGET_DB_JNDI}"

        bind(DataSource.class).annotatedWith(Names.named("reportingDBDS")).toInstance(reportingDBDataSource)
        bind(DataSource.class).annotatedWith(Names.named("targetDBDS")).toInstance(targetDBDataSource)

        //make the reporitng DB read/write
        bind(DSLContext).annotatedWith(Names.named("reportingDBDSLContext")).toProvider(new DSLContextProvider(reportingDBDataSource, false))
        //make the target DB readonly
        bind(DSLContext).annotatedWith(Names.named("targetDBDSLContext")).toProvider(new DSLContextProvider(targetDBDataSource, true))


    }

}
