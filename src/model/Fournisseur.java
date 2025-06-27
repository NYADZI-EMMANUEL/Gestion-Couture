package model;

public class Fournisseur extends Personne {
    private String fixe;

    public Fournisseur(String nom, String prenom, String telephone, String adresse, String fixe) {
        super(nom, prenom, telephone, adresse);
        this.fixe = fixe;
    }

    public String getFixe() {
        return fixe;
    }

    public void setFixe(String fixe) {
        this.fixe = fixe;
    }

    @Override
    public String toString() {
        return "[FOURNISSEUR] " + super.toString() + ", Fixe: " + fixe;
    }
}
