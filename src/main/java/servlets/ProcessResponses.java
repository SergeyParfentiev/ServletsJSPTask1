package servlets;

import objects.Questionnaire;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "fill", urlPatterns = "/fill")
public class ProcessResponses extends HttpServlet {

    private Questionnaire questionnaire = Questionnaire.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        questionnaire.addUser(req.getParameter("name"), req.getParameter("surname"), req.getParameter("age"));
        questionnaire.addVanillaAnswer(req.getParameter("vanilla"));
        questionnaire.addGovernorAnswer(req.getParameter("governor"));
        questionnaire.addGalaxyAnswer(req.getParameter("galaxy"));
        resp.sendRedirect("/show");
    }
}
