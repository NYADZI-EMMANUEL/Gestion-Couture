package model;

public class ResponsableProduction {
    private String nom;
    private String prenom;
    private String telephone;
    private String adresse;
    private double salaire;
    private String photo;

    public ResponsableProduction(String nom, String prenom, String telephone, String adresse, double salaire, String photo) {
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

    public String getPrenom() {
        return prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public double getSalaire() {
        return salaire;
    }

    public String getPhoto() {
        return photo;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "[RESP. PROD] " + nom + " " + prenom + " | Tél: " + telephone + 
               " | Adresse: " + adresse + " | Salaire: " + salaire + " | Photo: " + photo;
    }
}
