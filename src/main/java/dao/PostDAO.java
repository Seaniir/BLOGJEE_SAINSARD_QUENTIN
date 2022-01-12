package dao;

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

public class PostDAO implements  IDAO<Post>{
    Connection connect = Connect.getConnection();
    ResultSet rs = null;

    @Override
    public boolean create(Post object) {
        boolean msg = false;
        try {
            PreparedStatement req = connect.prepareStatement("INSERT INTO posts (titre, resume, contenu, created_at, auteur)"
                    + "VALUES (?,?,?,NOW(),?)");
            req.setString(1, object.getTitre());
            req.setString(2, object.getResume());
            req.setString(3, object.getContenu());
            req.setInt(4, object.getAuteur());

            System.out.println(req);

            req.executeUpdate();

            System.out.println(object.getTitre() + " " + object.getId() + " à bien été ajouté en BDD");
            msg = true;

        }catch (Exception e) {
            System.out.println("Insertion KO");
        }
        return msg;
    }

    @Override
    public List<Post> read() {
        List<Post> liste = new ArrayList<>();
        try {
            PreparedStatement req = connect.prepareStatement("SELECT * FROM `posts` INNER JOIN users on auteur = users.token");

            rs = req.executeQuery();

            while(rs.next()) {
                Post post = new Post(rs.getInt("id"), rs.getString("titre"), rs.getString("resume"), rs.getString("contenu"),
                        (Date) rs.getDate("created_at"), rs.getInt("auteur"), rs.getString("nom"), rs.getString("prenom"));
                liste.add(post);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return liste;
    }

    @Override
    public List<Post> readById(int id) {
        return null;
    }

    @Override
    public void update(Post object) {

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
    public Post findById(int id) {

        Post postById = null;

        try {
            PreparedStatement req = connect.prepareStatement("SELECT * FROM `posts` INNER JOIN users on auteur = users.token WHERE id=?");
            req.setInt(1, id);
            rs = req.executeQuery();
            while(rs.next()) {
                postById = new Post(rs.getInt("id"), rs.getString("titre"), rs.getString("resume"), rs.getString("contenu"),
                        (Date) rs.getDate("created_at"), rs.getInt("auteur"), rs.getString("nom"), rs.getString("prenom"));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return postById;
    }

    @Override
    public Post connectUser(String email, String password) {
        return null;
    }

    @Override
    public List<Post> findByName(String nom) {
        return null;
    }
}
