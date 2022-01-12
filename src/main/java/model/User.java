package model;

public class User {
    private int token;
    private String nom = "";
    private String prenom = "";
    private String email = "";
    private String password = "";

    public User(String nom, String prenom, String email, String password)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
    }

    public User(int token, String nom, String prenom, String email, String password)
    {
        this.token = token;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
    }

    public int getToken() {
        return token;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
