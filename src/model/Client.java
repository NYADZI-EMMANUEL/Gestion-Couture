package model;

public class Client {
    private String nom;
    private String prenom;
    private String telephone;
    private String adresse;
    private String observation;

    public Client(String nom, String prenom, String telephone, String adresse, String observation) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.adresse = adresse;
        this.observation = observation;
    }

    public String getNomComplet() {
        return nom + " " + prenom;
    }

    public String getTelephone() { return telephone; }

    @Override
    public String toString() {
        return "[CLIENT] " + getNomComplet() + " | Tél: " + telephone + " | Adr: " + adresse + " | Obs: " + observation;
    }
}
