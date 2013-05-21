package com.practicecamp.services.subscriber

import com.practicecamp.services.subscriber.health.SubscriberHealthCheck
import com.practicecamp.services.subscriber.resources.SubscriberResource
import com.yammer.dropwizard.Service
import com.yammer.dropwizard.assets.AssetsBundle
import com.yammer.dropwizard.config.Bootstrap
import com.yammer.dropwizard.config.Environment
import com.yammer.dropwizard.db.DatabaseConfiguration
import com.yammer.dropwizard.migrations.MigrationsBundle

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
  }

  @Override
  public void run(SubscriberConfiguration configuration, Environment environment) throws ClassNotFoundException {
    environment.addHealthCheck(new SubscriberHealthCheck(configuration.serviceName))
    environment.addResource(new SubscriberResource())
  }
}
