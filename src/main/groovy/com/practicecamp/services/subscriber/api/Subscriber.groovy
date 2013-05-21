package com.practicecamp.services.subscriber.api

import com.fasterxml.jackson.annotation.JsonProperty
import com.google.common.base.Objects
import org.hibernate.validator.constraints.Email
import org.hibernate.validator.constraints.Length

/**
 * Created with IntelliJ IDEA.
 * User: domix
 * Date: 20/05/13
 * Time: 19:35
 * To change this template use File | Settings | File Templates.
 */
class Subscriber {
  @JsonProperty
  @Length(max = 60)
  @Email
  String email

  String toString() {
    Objects.toStringHelper(this)
      .add('email', email)
      .toString()
  }
}
