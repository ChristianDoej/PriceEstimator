package server.endpoints;

import com.google.gson.Gson;
import server.controller.MainController;
import server.controller.TokenController;
import server.models.Event;
import server.models.User;
import server.utility.Crypter;
import server.utility.CurrentUserContext;
import server.utility.Globals;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/event")
public class EventEndpoint {

    @POST
    @Path("/create")
    public Response createEvent(Event event) {
         int k = 0;

        if (k==0) {
            return Response.status(200).type("application/json").entity(new Gson().toJson(k)).build();
        } else {
            return Response.status(401).type("text/plain").entity("Error signing in - unauthorized").build();
        }
    }
}
