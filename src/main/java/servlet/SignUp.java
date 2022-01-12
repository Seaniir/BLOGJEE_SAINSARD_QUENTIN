package servlet;

import dao.UserDAO;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "signupServlet", value = "/signup-servlet")
public class SignUp extends HttpServlet {
    static private User currentUser = null;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        // Hello
        request.getRequestDispatcher("SignUp.jsp").forward(
                request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String purposeParam = request.getParameter("purpose");
        if(purposeParam.equals("C")) {
                String nom = request.getParameter("nom");
                String prenom = request.getParameter("prenom");
                String email = request.getParameter("email");
                String password = request.getParameter("password");

                User user = new User(nom, prenom, email, password);
                UserDAO userDAO = new UserDAO();
                userDAO.create(user);
            }
        if(purposeParam.equals("L")) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            UserDAO userDAO = new UserDAO();
            currentUser = userDAO.connectUser(email, password);
            HttpSession session = request.getSession();

            session.setAttribute("user", currentUser);
        }
        if(purposeParam.equals("D")) {
            HttpSession session = request.getSession();
            session.invalidate();
        }
        this.doGet(request, response);

    }
}
