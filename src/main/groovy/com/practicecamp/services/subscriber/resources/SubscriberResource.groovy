package com.practicecamp.services.subscriber.resources

import com.practicecamp.services.subscriber.api.Subscriber
import com.practicecamp.services.subscriber.jdbi.SubscriberDAO
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import javax.validation.Valid
import javax.ws.rs.PUT
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import java.sql.Timestamp

/**
 * Created with IntelliJ IDEA.
 * User: domix
 * Date: 20/05/13
 * Time: 19:43
 * To change this template use File | Settings | File Templates.
 */
@Path('/subscribe')
@Produces(MediaType.APPLICATION_JSON)
class SubscriberResource {
  private static final Logger LOGGER = LoggerFactory.getLogger(SubscriberResource)
  String serviceName
  SubscriberDAO dao

  @PUT
  void receiveSubscriber(@Valid Subscriber subscriber) {
    LOGGER.info("Received a subscriber: {}", subscriber);
    dao.insert(serviceName, subscriber.email, new Timestamp(System.currentTimeMillis()))
  }
}
