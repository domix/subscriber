package com.practicecamp.services.subscriber

import com.fasterxml.jackson.annotation.JsonProperty
import com.yammer.dropwizard.config.Configuration
import com.yammer.dropwizard.db.DatabaseConfiguration

import javax.validation.Valid
import javax.validation.constraints.NotNull

/**
 * Created with IntelliJ IDEA.
 * User: domix
 * Date: 20/05/13
 * Time: 18:41
 * To change this template use File | Settings | File Templates.
 */
class SubscriberConfiguration extends Configuration {
  @Valid
  @NotNull
  @JsonProperty("database")
  DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration();
}
