package com.rankmob.service.api;

import com.rankmob.service.transport.RankServiceTransport;
import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
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
@Produces(MediaType.APPLICATION_JSON)
public class RankService {
    private RankServiceTransport rankServiceTransport;

    @Autowired
    public RankService(RankServiceTransport rankServiceTransport) {
        this.rankServiceTransport = rankServiceTransport;
    }

    @GET
    @Path("hello")
    public Response hello() {
        return Response.ok("Hello").build();
    }

    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    public TokenResponse login(LoginContext context) {
        String token = rankServiceTransport.login(context);
        TokenResponse response = new TokenResponse();
        response.setToken(token);
        return response;
    }

    @POST
    @Path("register")
    @Consumes(MediaType.APPLICATION_JSON)
    public TokenResponse register(RegisterContext context) {
        String token = rankServiceTransport.register(context);
        TokenResponse response = new TokenResponse();
        response.setToken(token);
        return response;
    }
}
