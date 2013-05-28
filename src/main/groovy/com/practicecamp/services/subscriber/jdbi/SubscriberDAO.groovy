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