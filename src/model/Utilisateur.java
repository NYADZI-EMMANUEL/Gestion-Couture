package model;

public class Utilisateur extends Personne {
    protected double salaire;

    public Utilisateur(String nom, String prenom, String telephone, String adresse, double salaire) {
        super(nom, prenom, telephone, adresse);
        this.salaire = salaire;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    @Override
    public String toString() {
        return super.toString() + ", Salaire: " + salaire;
    }
}
