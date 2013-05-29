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
