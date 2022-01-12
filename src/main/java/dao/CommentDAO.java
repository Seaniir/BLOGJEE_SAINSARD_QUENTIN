package dao;

import model.Comment;
import model.Post;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class CommentDAO implements  IDAO<Comment>{
    Connection connect = Connect.getConnection();
    ResultSet rs = null;

    @Override
    public boolean create(Comment object) {
        boolean msg = false;
        try {
            PreparedStatement req = connect.prepareStatement("INSERT INTO comments (auteur, post, contenu)"
                    + "VALUES (?,?,?)");
            req.setInt(1, object.getAuteur());
            req.setInt(2, object.getPost());
            req.setString(3, object.getContenu());

            System.out.println(req);

            req.executeUpdate();

            System.out.println(object.getContenu() + " " + object.getAuteur() + " à bien été ajouté en BDD");
            msg = true;

        }catch (Exception e) {
            System.out.println("Insertion KO");
        }
        return msg;
    }

    @Override
    public List<Comment> read() {
        return null;
    }

    @Override
    public List<Comment> readById(int id) {
        List<Comment> liste = new ArrayList<>();
        try {
            PreparedStatement req = connect.prepareStatement("SELECT * FROM `comments` INNER JOIN users ON auteur = users.token WHERE post=?");
            req.setInt(1, id);
            rs = req.executeQuery();

            while(rs.next()) {
                Comment post = new Comment(rs.getInt("id"), rs.getInt("auteur"),
                        rs.getInt("post"), rs.getString("contenu"), rs.getString("nom"), rs.getString("prenom"));
                liste.add(post);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return liste;
    }

    @Override
    public void update(Comment object) {

    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement req = connect.prepareStatement("DELETE FROM conducteur WHERE id_conducteur=?");
            req.setInt(1, id);
            //System.out.println(req);
            req.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public Comment findById(int id) {

        Comment postById = null;

        try {
            PreparedStatement req = connect.prepareStatement("SELECT * FROM `posts` INNER JOIN users on auteur = users.token WHERE id=?");
            req.setInt(1, id);
            rs = req.executeQuery();
            while(rs.next()) {
                //postById = new Post(rs.getInt("id"), rs.getString("titre"), rs.getString("resume"), rs.getString("contenu"),
                 //       (Date) rs.getDate("created_at"), rs.getInt("auteur"), rs.getString("nom"), rs.getString("prenom"));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return postById;
    }

    @Override
    public Comment connectUser(String email, String password) {
        return null;
    }

    @Override
    public List<Comment> findByName(String nom) {
        return null;
    }
}
