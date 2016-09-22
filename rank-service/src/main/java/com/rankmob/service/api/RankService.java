package com.rankmob.service.api;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.apache.cxf.helpers.HttpHeaderHelper.AUTHORIZATION;
import static org.apache.cxf.helpers.HttpHeaderHelper.CONTENT_TYPE;

@Component("rankService")
@Path("rank")
@CrossOriginResourceSharing(
        allowCredentials = true,
        allowAllOrigins = true,
        allowHeaders = {
                CONTENT_TYPE,
                AUTHORIZATION
        },
        maxAge = 1
)
public class RankService {
    @GET
    @Path("hello")
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello() {
        return Response.ok("Hello").build();
    }
}
