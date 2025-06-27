package model;

public class ArticleConfection {
    private String libelle;
    private double prixAchat;
    private int quantiteStock;
    private double montantStock;
    private String photo;

    public ArticleConfection(String libelle, double prixAchat, int quantiteStock, double montantStock, String photo) {
        this.libelle = libelle;
        this.prixAchat = prixAchat;
        this.quantiteStock = quantiteStock;
        this.montantStock = montantStock;
        this.photo = photo;
    }

    public String getLibelle() { return libelle; }
    public double getPrixAchat() { return prixAchat; }
    public int getQuantiteStock() { return quantiteStock; }
    public double getMontantStock() { return montantStock; }

    public void setQuantiteStock(int quantiteStock) {
        this.quantiteStock = quantiteStock;
        this.montantStock = this.quantiteStock * this.prixAchat;
    }

    public boolean diminuerStock(int quantiteVendue) {
        if (quantiteVendue <= this.quantiteStock) {
            this.quantiteStock -= quantiteVendue;
            this.montantStock = this.quantiteStock * this.prixAchat;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "[ARTICLE] " + libelle + " | Prix: " + prixAchat + " | Stock: " + quantiteStock + " | Montant: " + montantStock;
    }
}
