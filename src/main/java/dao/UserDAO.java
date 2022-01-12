package dao;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserDAO implements  IDAO<User>{
    Connection connect = Connect.getConnection();
    ResultSet rs = null;

    @Override
    public boolean create(User object) {
        int min = 10000000;
        int max = 90000000;
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        boolean msg = false;
        try {
            PreparedStatement req = connect.prepareStatement("INSERT INTO users (token, nom, prenom, email, password)"
                    + "VALUES (?,?,?,?,PASSWORD(?))");
            req.setInt(1, random_int);
            req.setString(2, object.getNom());
            req.setString(3, object.getPrenom());
            req.setString(4, object.getEmail());
            req.setString(5, object.getPassword());

            System.out.println(req);

            req.executeUpdate();

            System.out.println(object.getPrenom() + " " + object.getNom() + " à bien été ajouté en BDD");
            msg = true;

        }catch (Exception e) {
            System.out.println("Insertion KO");
        }
        return msg;
    }

    @Override
    public List<User> read() {
        List<User> liste = new ArrayList<>();
        try {
            PreparedStatement req = connect.prepareStatement("SELECT * FROM conducteur");

            rs = req.executeQuery();

            while(rs.next()) {
               //User conducteur = new User(rs.getInt("id_conducteur"), rs.getString("nom"), rs.getString("prenom"));
                //liste.add(conducteur);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return liste;
    }

    @Override
    public List<User> readById(int id) {
        return null;
    }

    @Override
    public void update(User object) {

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
    public User findById(int id) {
        return null;
    }

    @Override
    public User connectUser(String email, String password) {

        User conduById = null;

        try {
            PreparedStatement req = connect.prepareStatement("SELECT * FROM users WHERE email=? AND password=PASSWORD(?)");
            req.setString(1, email);
            req.setString(2, password);
            rs = req.executeQuery();
            while(rs.next()) {
                conduById = new User(rs.getInt("token"),rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("password"));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conduById;
    }

    @Override
    public List<User> findByName(String nom) {
        return null;
    }
}
