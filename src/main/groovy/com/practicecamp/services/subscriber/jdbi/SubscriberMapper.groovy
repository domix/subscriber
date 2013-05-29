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

import com.practicecamp.services.subscriber.api.Subscriber
import org.skife.jdbi.v2.StatementContext
import org.skife.jdbi.v2.tweak.ResultSetMapper

import java.sql.ResultSet
import java.sql.SQLException

/**
 * Created with IntelliJ IDEA.
 * User: domix
 * Date: 29/05/13
 * Time: 00:20
 * To change this template use File | Settings | File Templates.
 */
class SubscriberMapper implements ResultSetMapper<Subscriber> {
  @Override
  Subscriber map(int index, ResultSet r, StatementContext ctx) throws SQLException {
    new Subscriber(id: r.getLong('id'), email: r.getString('email'), dateCreated: r.getTimestamp('date_created'))
  }
}
