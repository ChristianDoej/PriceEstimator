package server.endpoints;

import com.google.gson.Gson;
import server.controller.QuizController;
import server.controller.MainController;
import server.controller.TokenController;
import server.dbmanager.DbManager;
import server.models.Quiz;
import server.utility.Crypter;
import server.utility.CurrentUserContext;
import server.utility.Globals;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("/quiz")
public class QuizEndpoint {
    DbManager dbManager = new DbManager();
    QuizController quizController = new QuizController();
    TokenController tokenController = new TokenController();

    Crypter crypter = new Crypter();


    @GET
    @Path("/{CourseID}")
    public Response loadQuizzes(@HeaderParam("authorization") String token, @PathParam("CourseID") int courseId) throws SQLException {
        CurrentUserContext currentUser = tokenController.getUserFromTokens(token);

        if (currentUser.getCurrentUser() != null) {
            ArrayList<Quiz> quizzes = quizController.loadQuizzes(courseId);
            String loadedQuizzes = new Gson().toJson(quizzes);
            loadedQuizzes = crypter.encryptAndDecryptXor(loadedQuizzes);

            if (quizzes != null) {
                return Response.status(200).type("application/json").entity(new Gson().toJson(loadedQuizzes)).build();
            } else {
                return Response.status(204).type("text/plain").entity("No quizzes").build();
            }
        } else {
            return Response.status(401).type("text/plain").entity("Unauthorized").build();
        }
    }

    @POST
    // Method for creating a quiz
    public Response createQuiz(@HeaderParam("authorization") String token, String quiz) throws SQLException {
        String cryptedQuiz = crypter.encryptAndDecryptXor(quiz);
        CurrentUserContext currentUser = tokenController.getUserFromTokens(token);

        if (currentUser.getCurrentUser() != null && currentUser.isAdmin()) {
            Quiz quizCreated = quizController.createQuiz(new Gson().fromJson(cryptedQuiz, Quiz.class));
            String newQuiz = new Gson().toJson(quizCreated);
            newQuiz = crypter.encryptAndDecryptXor(newQuiz);

            if (quizCreated != null) {
                return Response.status(200).type("application/json").entity(new Gson().toJson(newQuiz)).build();
            } else {
                return Response.status(400).type("text/plain").entity("Failed creating quiz").build();
            }
        } else {
            return Response.status(401).type("text/plain").entity("Unauthorized").build();
        }
    }


    @DELETE
    @Path("{deleteId}")
    // Method for deleting a quiz and all it's sub-tables
    public Response deleteQuiz(@HeaderParam("authorization") String token, @PathParam("deleteId") int quizId) throws SQLException {
        CurrentUserContext currentUser = tokenController.getUserFromTokens(token);

        if (currentUser.getCurrentUser() != null && currentUser.isAdmin()) {
            Boolean quizDeleted = quizController.deleteQuiz(quizId);
            if (quizDeleted = true) {
                return Response.status(200).type("text/plain").entity("Quiz deleted").build();
            } else {
                return Response.status(400).type("text/plain").entity("Error deleting quiz").build();
            }
        } else {
            return Response.status(401).type("text/plain").entity("Unauthorized").build();
        }
    }

}
