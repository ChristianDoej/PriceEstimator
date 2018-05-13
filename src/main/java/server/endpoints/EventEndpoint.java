package server.endpoints;

import com.google.gson.Gson;
import server.controller.EventController;
import server.controller.MainController;
import server.controller.QuizController;
import server.controller.TokenController;
import server.dbmanager.DbManager;
import server.models.Event;
import server.models.Quiz;
import server.models.User;
import server.utility.Crypter;
import server.utility.CurrentUserContext;
import server.utility.Globals;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/event")
public class EventEndpoint {
    DbManager dbManager = new DbManager();
    QuizController quizController = new QuizController();
    TokenController tokenController = new TokenController();
    EventController eventController = new EventController();

    Crypter crypter = new Crypter();

    @POST
    @Path("/create")
    public Response createEvent(String event) {
       // Quiz quizCreated = quizController.createQuiz(new Gson().fromJson(cryptedQuiz, Quiz.class));
       // String newQuiz = new Gson().toJson(quizCreated);
       // newQuiz = crypter.encryptAndDecryptXor(newQuiz);

       // String cryptedEvent = crypter.encryptAndDecryptXor(event);

        Event eventCreated = eventController.createEvent(new Gson().fromJson(event, Event.class));
        String newEvent = new Gson().toJson(eventCreated);


        if (eventCreated != null) {
            return Response.status(200).type("application/json").entity(new Gson().toJson(newEvent)).build();
        } else {
            return Response.status(401).type("text/plain").entity("Failed creating event").build();
        }
    }
}


