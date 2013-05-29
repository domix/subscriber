package com.practicecamp.services.subscriber.resources

import com.practicecamp.services.subscriber.api.Subscriber
import com.practicecamp.services.subscriber.jdbi.SubscriberDAO
import org.junit.Before
import org.junit.Test

import static org.mockito.Mockito.mock

/**
 * Created with IntelliJ IDEA.
 * User: domix
 * Date: 28/05/13
 * Time: 20:56
 * To change this template use File | Settings | File Templates.
 */
class SubscriberResourceTest {
  SubscriberResource resource
  SubscriberDAO dao

  @Before
  void setup() {
    dao = mock(SubscriberDAO)
    resource = new SubscriberResource(serviceName: 'test', dao: dao)
  }

  @Test
  void shouldFoo() {
    Subscriber subscriber = new Subscriber(email: 'test@foo.com')
    subscriber.toString()
    resource.receiveSubscriber(subscriber)
  }
}
