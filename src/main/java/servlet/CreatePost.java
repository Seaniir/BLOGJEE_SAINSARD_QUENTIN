package servlet;

import dao.PostDAO;
import dao.UserDAO;
import model.Post;
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

@WebServlet(name = "createpostservlet", value = "/createpost-servlet")
public class CreatePost extends HttpServlet {
    static private User currentUser = null;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        // Hello
        request.getRequestDispatcher("CreatePost.jsp").forward(
                request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String purposeParam = request.getParameter("purpose");
        if(purposeParam.equals("C")) {
            String titre = request.getParameter("titre");
            String resume = request.getParameter("resume");
            String contenu = request.getParameter("contenu");
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            Post post = new Post(titre, resume, contenu, user.getToken());
            PostDAO postDAO = new PostDAO();
            postDAO.create(post);
        }
        this.doGet(request, response);

    }
}
