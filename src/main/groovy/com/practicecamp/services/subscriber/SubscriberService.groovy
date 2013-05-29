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

import com.practicecamp.services.subscriber.health.SubscriberHealthCheck
import com.practicecamp.services.subscriber.jdbi.SubscriberDAO
import com.practicecamp.services.subscriber.resources.SubscriberResource
import com.yammer.dropwizard.Service
import com.yammer.dropwizard.assets.AssetsBundle
import com.yammer.dropwizard.config.Bootstrap
import com.yammer.dropwizard.config.Environment
import com.yammer.dropwizard.db.DatabaseConfiguration
import com.yammer.dropwizard.jdbi.DBIFactory
import com.yammer.dropwizard.jdbi.bundles.DBIExceptionsBundle
import com.yammer.dropwizard.migrations.MigrationsBundle
import org.skife.jdbi.v2.DBI

/**
 * Created with IntelliJ IDEA.
 * User: domix
 * Date: 20/05/13
 * Time: 18:25
 * To change this template use File | Settings | File Templates.
 */
class SubscriberService extends Service<SubscriberConfiguration> {
  public static void main(String[] args) throws Exception {
    new SubscriberService().run(args)
  }

  @Override
  public void initialize(Bootstrap<SubscriberConfiguration> bootstrap) {
    bootstrap.name = "subscriber"
    bootstrap.addBundle(new AssetsBundle())
    bootstrap.addBundle(new MigrationsBundle<SubscriberConfiguration>() {
      @Override
      public DatabaseConfiguration getDatabaseConfiguration(SubscriberConfiguration configuration) {
        configuration.databaseConfiguration
      }
    })
    bootstrap.addBundle(new DBIExceptionsBundle())
  }

  @Override
  public void run(SubscriberConfiguration configuration, Environment environment) throws ClassNotFoundException {
    String serviceName = configuration.serviceName

    final DBIFactory factory = new DBIFactory()
    final DBI jdbi = factory.build(environment, configuration.getDatabaseConfiguration(), 'postgresql')
    final SubscriberDAO dao = jdbi.onDemand(SubscriberDAO)

    environment.addHealthCheck(new SubscriberHealthCheck(serviceName))
    environment.addResource(new SubscriberResource(serviceName: serviceName, dao: dao))
  }
}
