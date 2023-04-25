/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to you under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.logging.log4j.core.appender.db.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.logging.log4j.core.test.appender.db.jdbc.JdbcH2TestHelper;
import org.apache.logging.log4j.core.test.junit.JdbcRule;
import org.junit.Before;

/**
 *
 */
public class JdbcAppenderH2FactoryMethodTest extends AbstractJdbcAppenderFactoryMethodTest {

    public JdbcAppenderH2FactoryMethodTest() {
        super(new JdbcRule(JdbcH2TestHelper.TEST_CONFIGURATION_SOURCE_MEM,
                "CREATE TABLE fmLogEntry ("
                        + "id INTEGER, eventDate DATETIME, literalColumn VARCHAR(255), level NVARCHAR(10), "
                        + "logger NVARCHAR(255), message VARCHAR(1024), exception NCLOB, anotherDate TIMESTAMP)",
                "DROP TABLE IF EXISTS fmLogEntry"), "h2");
    }

    @Before
    public void afterEachDeleteDir() throws IOException {
        JdbcH2TestHelper.deleteDir();
    }

    @Before
    public void beforeEachDeleteDir() throws IOException {
        JdbcH2TestHelper.deleteDir();
    }

    public static Connection getConnection() throws SQLException {
        return JdbcH2TestHelper.getConnectionInMemory();
    }
}
