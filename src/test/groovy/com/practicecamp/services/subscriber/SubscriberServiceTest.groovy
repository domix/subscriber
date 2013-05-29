package com.practicecamp.services.subscriber

import com.yammer.dropwizard.config.Environment
import com.yammer.dropwizard.db.DatabaseConfiguration
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
  private final DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration()

  @Before
  void setup() throws Exception {
    config.serviceName = 'test'
    databaseConfiguration.driverClass = 'org.postgresql.Driver'
    databaseConfiguration.user = 'subscriber_usr'
    databaseConfiguration.password = 'dg5UG7cj2qKd'
    databaseConfiguration.url = 'jdbc:postgresql://localhost:5432/subscriber_data'

    config.setDatabaseConfiguration(databaseConfiguration)
  }

  @Test
  void shouldRun() {
    service.run(config, environment)
  }
}
