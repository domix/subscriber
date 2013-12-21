package com.practicecamp.services.subscriber.resources

import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response
import javax.ws.rs.ext.ExceptionMapper


/**
 * Created with IntelliJ IDEA.
 * User: dsuarez
 * Date: 6/14/13
 * Time: 11:30 AM
 * To change this template use File | Settings | File Templates.
 */
class InvalidRequestExceptionMapper { //implements ExceptionMapper<InvalidEntityException> {

  /*@Override
    public Response toResponse(InvalidEntityException e) {
        Response.status(422)
                .type(MediaType.APPLICATION_JSON)
                .entity(e.getErrors())
                .build();
    }*/
}
