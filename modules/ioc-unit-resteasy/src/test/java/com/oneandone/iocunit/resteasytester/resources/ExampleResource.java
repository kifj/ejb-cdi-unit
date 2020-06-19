package com.oneandone.iocunit.resteasytester.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.oneandone.iocunit.resteasytester.InjectTest;

/**
 * @author aschoerk
 */
@Path("/restpath")
public class ExampleResource {
    @Inject
    InjectTest injectTest;

    @GET
    @Path("/method1")
    public Response method1() {
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/postdto")
    public Response postDto(ExampleDto dto) {
        return Response.ok(dto).build();
    }

    @GET
    @Path("/error")
    public Response error() {
        throw new RuntimeException();
    }

    @GET
    @Path("/injecttest")
    public Response injectTest() {
        injectTest.callInjectTest();
        return Response.ok().build();
    }
}
