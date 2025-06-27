package model;

public class Production {
    private String date;
    private String article;
    private int quantite;
    private String observation;

    public Production(String date, String article, int quantite, String observation) {
        this.date = date;
        this.article = article;
        this.quantite = quantite;
        this.observation = observation;
    }

    public String getDate() {
        return date;
    }

    public String getArticle() {
        return article;
    }

    public int getQuantite() {
        return quantite;
    }

    public String getObservation() {
        return observation;
    }

    @Override
    public String toString() {
        return "[PRODUCTION] Date: " + date + " | Article: " + article + " | Qté: " + quantite + " | Obs: " + observation;
    }
}
