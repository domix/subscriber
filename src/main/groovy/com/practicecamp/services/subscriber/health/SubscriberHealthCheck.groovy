package com.practicecamp.services.subscriber.health

import com.yammer.metrics.core.HealthCheck

/**
 * Created with IntelliJ IDEA.
 * User: domix
 * Date: 20/05/13
 * Time: 19:48
 * To change this template use File | Settings | File Templates.
 */
class SubscriberHealthCheck extends HealthCheck {
  SubscriberHealthCheck(String name) {
    super(name)
  }

  @Override
  protected com.yammer.metrics.core.HealthCheck.Result check() throws Exception {
    return com.yammer.metrics.core.HealthCheck.Result.healthy()
  }
}
