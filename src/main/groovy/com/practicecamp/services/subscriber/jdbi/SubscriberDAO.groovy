package com.practicecamp.services.subscriber.jdbi

import org.skife.jdbi.v2.sqlobject.Bind
import org.skife.jdbi.v2.sqlobject.SqlUpdate

/**
 * Created with IntelliJ IDEA.
 * User: domix
 * Date: 21/05/13
 * Time: 11:55
 * To change this template use File | Settings | File Templates.
 */
interface SubscriberDAO {
  @SqlUpdate("insert into subscribers (id, name) values (:id, :name)")
  void insert(@Bind("email") String email)
}