package servlet;

import dao.CommentDAO;
import dao.PostDAO;
import dao.UserDAO;
import model.Comment;
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

@WebServlet(name = "detailpostservlet", value = "/detailpost-servlet")
public class DetailPost extends HttpServlet {
    static private User currentUser = null;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        // Hello
        int postParam = Integer.parseInt(request.getParameter("post"));
        PostDAO postDAO = new PostDAO();
        Post newPost = postDAO.findById(postParam);
        request.setAttribute("post", newPost);
        CommentDAO commentDAO = new CommentDAO();
        List<Comment> commentList = new ArrayList<>();
        commentList = commentDAO.readById(newPost.getId());
        request.setAttribute("commentList", commentList);
        request.getRequestDispatcher("DetailPost.jsp").forward(
                request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String purposeParam = request.getParameter("purpose");
        int post = Integer.parseInt(request.getParameter("post"));
        if(purposeParam != null) {
            if (purposeParam.equals("C")) {
                String contenu = request.getParameter("comment");
                HttpSession session = request.getSession();
                User user = (User) session.getAttribute("user");
                Comment comment = new Comment(user.getToken(), post, contenu);
                CommentDAO commentDAO = new CommentDAO();
                commentDAO.create(comment);
            }
        }
        this.doGet(request, response);
    }
}
