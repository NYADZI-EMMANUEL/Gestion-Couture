
package model;

public class Personne {
    protected String nom;
    protected String prenom;
    protected String telephone;
    protected String adresse;

    public Personne(String nom, String prenom, String telephone, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.adresse = adresse;
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

    public String toString() {
        return nom + " " + prenom + ", Tel: " + telephone + ", Adresse: " + adresse;
    }

    public boolean egal(Personne autre) {
        return this.nom.equalsIgnoreCase(autre.nom) && this.prenom.equalsIgnoreCase(autre.prenom);
    }
}
