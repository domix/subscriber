/* Copyright 2013 the original author or authors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.practicecamp.services.subscriber

import io.dropwizard.db.DatabaseConfiguration
import io.dropwizard.setup.Environment
import org.junit.Before
import org.junit.Test

import static org.mockito.Mockito.mock

/**
 * Created with IntelliJ IDEA.
 * User: domix
 * Date: 28/05/13
 * Time: 20:37
 * To change this template use File | Settings | File Templates.
 */
class SubscriberServiceTest {
  private final Environment environment = mock(Environment)
  private final SubscriberService service = new SubscriberService()
  private final SubscriberConfiguration config = new SubscriberConfiguration()
  //private final DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration()

  @Before
  void setup() throws Exception {
    config.serviceName = 'test'
    /*databaseConfiguration.driverClass = 'org.postgresql.Driver'
    databaseConfiguration.user = 'subscriber_usr'
    databaseConfiguration.password = 'dg5UG7cj2qKd'
    databaseConfiguration.url = 'jdbc:postgresql://localhost:5432/subscriber_data'

    config.setDatabaseConfiguration(databaseConfiguration)*/
  }

  @Test
  void shouldRun() {
    //service.run(config, environment)
  }
}
