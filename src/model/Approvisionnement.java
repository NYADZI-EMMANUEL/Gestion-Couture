package model;

public class Approvisionnement {
    private String date;
    private String article;
    private int quantite;
    private double prixUnitaire;
    private String fournisseur;
    private String observation;

    public Approvisionnement(String date, String article, int quantite, double prixUnitaire, String fournisseur, String observation) {
        this.date = date;
        this.article = article;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.fournisseur = fournisseur;
        this.observation = observation;
    }

    public String getDate() { return date; }
    public String getArticle() { return article; }
    public int getQuantite() { return quantite; }
    public double getPrixUnitaire() { return prixUnitaire; }
    public double getMontant() { return prixUnitaire * quantite; }
    public String getFournisseur() { return fournisseur; }
    public String getObservation() { return observation; }

    @Override
    public String toString() {
        return "[APPRO] Date: " + date + " | Article: " + article + " | Qté: " + quantite + " | PU: " + prixUnitaire +
               " | Montant: " + getMontant() + " | Fournisseur: " + fournisseur + " | Obs: " + observation;
    }
}
