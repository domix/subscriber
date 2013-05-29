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
package com.practicecamp.services.subscriber.jdbi

import org.skife.jdbi.v2.sqlobject.Bind
import org.skife.jdbi.v2.sqlobject.SqlUpdate

import java.sql.Timestamp

/**
 * Created with IntelliJ IDEA.
 * User: domix
 * Date: 21/05/13
 * Time: 11:55
 * To change this template use File | Settings | File Templates.
 */
interface SubscriberDAO {
  @SqlUpdate('insert into subscriptions (service, email, date_created) values (:serviceName, :email, :dateCreated)')
  void insert(@Bind('serviceName') String serviceName, @Bind('email') String email, @Bind('dateCreated') Timestamp dateCreated)
}