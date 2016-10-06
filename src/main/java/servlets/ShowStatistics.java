package servlets;

import objects.Questionnaire;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "show", urlPatterns = "/show")
public class ShowStatistics extends HttpServlet{

    private Questionnaire questionnaire = Questionnaire.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("vanillaStatistics", questionnaire.getVanillaStatistics());
        req.setAttribute("governorStatistics", questionnaire.getGovernorStatistics());
        req.setAttribute("galaxyStatistics", questionnaire.getGalaxyStatistics());
        req.setAttribute("users", questionnaire.getUsers());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/questionnaire/ShowStatistics.jsp");
        dispatcher.forward(req, resp);
    }
}
