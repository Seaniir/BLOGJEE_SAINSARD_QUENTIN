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

@WebServlet(name = "homservlet", value = "/home-servlet")
public class Home extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        List<Post> postList = new ArrayList<>();
        PostDAO postDAO = new PostDAO();
        postList = postDAO.read();
        request.setAttribute("postList", postList);
        // Hello
        request.getRequestDispatcher("Home.jsp").forward(
                request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request, response);

    }
}
