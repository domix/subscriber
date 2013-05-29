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
