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
