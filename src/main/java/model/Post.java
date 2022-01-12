package model;

import java.util.Date;

public class Post {
    private int id;
    private String titre = "";
    private String resume = "";
    private String contenu = "";
    private Date created_at;
    private int auteur;
    private String nomAuteur;
    private String prenomAuteur;

    public Post(String titre, String resume, String contenu, int auteur)
    {
        this.titre = titre;
        this.resume = resume;
        this.contenu = contenu;
        this.auteur = auteur;
    }

    public Post(int id, String titre, String resume, String contenu, int auteur)
    {
        this.id = id;
        this.titre = titre;
        this.resume = resume;
        this.contenu = contenu;
        this.auteur = auteur;
    }

    public Post(int id, String titre, String resume, String contenu, Date created_at, int auteur, String nomAuteur, String prenomAuteur)
    {
        this.id = id;
        this.titre = titre;
        this.resume = resume;
        this.contenu = contenu;
        this.created_at = created_at;
        this.auteur = auteur;
        this.nomAuteur = nomAuteur;
        this.prenomAuteur = prenomAuteur;
    }

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getResume() {
        return resume;
    }

    public String getContenu() {
        return contenu;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public int getAuteur() {
        return auteur;
    }

    public String getNomAuteur() {
        return nomAuteur;
    }

    public String getPrenomAuteur() {
        return prenomAuteur;
    }
}
