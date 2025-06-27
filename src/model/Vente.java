package model;

public class Vente {
    private String date;
    private String article;
    private int quantite;
    private double prixUnitaire;
    private double montant;
    private String client;
    private String observation;

    public Vente(String date, String article, int quantite, double prixUnitaire, String client, String observation) {
        this.date = date;
        this.article = article;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.montant = quantite * prixUnitaire;
        this.client = client;
        this.observation = observation;
    }

    public String getClient() { return client; }
    public String getArticle() { return article; }

    @Override
    public String toString() {
        return "[VENTE] Date: " + date + " | Article: " + article + " | Qté: " + quantite +
               " | PU: " + prixUnitaire + " | Montant: " + montant + " | Client: " + client +
               " | Obs: " + observation;
    }
}
