package model;

public class Vendeur {
    private String nom;
    private String prenom;
    private String telephone;
    private String adresse;
    private double salaire;
    private String photo;

    public Vendeur(String nom, String prenom, String telephone, String adresse, double salaire, String photo) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.adresse = adresse;
        this.salaire = salaire;
        this.photo = photo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "[VENDEUR] " + nom + " " + prenom + " | Tél: " + telephone + " | Adresse: " + adresse +
                " | Salaire: " + salaire + " | Photo: " + photo;
    }
}
