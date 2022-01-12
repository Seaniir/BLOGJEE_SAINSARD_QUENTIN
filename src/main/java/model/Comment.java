package model;

import java.util.Date;

public class Comment {
    private int id;
    private int auteur;
    private int post;
    private String contenu = "";
    private String NomAuteur = "";
    private String PrenomAuteur = "";

    public Comment(int auteur, int post, String contenu)
    {
        this.auteur = auteur;
        this.post = post;
        this.contenu = contenu;
    }

    public Comment(int id, int auteur, int post, String contenu, String NomAuteur, String PrenomAuteur)
    {
        this.id = id;
        this.auteur = auteur;
        this.post = post;
        this.contenu = contenu;
        this.NomAuteur = NomAuteur;
        this.PrenomAuteur = PrenomAuteur;
    }

    public Comment(String contenu)
    {
        this.contenu = contenu;
    }

    public int getId() {
        return id;
    }

    public int getAuteur() {
        return auteur;
    }

    public int getPost() {
        return post;
    }

    public String getContenu() {
        return contenu;
    }

    public String getNomAuteur() {
        return NomAuteur;
    }

    public String getPrenomAuteur() {
        return PrenomAuteur;
    }
}
