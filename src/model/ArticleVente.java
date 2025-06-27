package model;

public class ArticleVente {
    private String libelle;
    private double prixVente;
    private int quantiteStock;
    private double montantStock;
    private String photo;

    public ArticleVente(String libelle, double prixVente, int quantiteStock, String photo) {
        this.libelle = libelle;
        this.prixVente = prixVente;
        this.quantiteStock = quantiteStock;
        this.montantStock = prixVente * quantiteStock;
        this.photo = photo;
    }

    public String getLibelle() {
        return libelle;
    }

    public double getPrixVente() {
        return prixVente;
    }

    public int getQuantiteStock() {
        return quantiteStock;
    }

    public double getMontantStock() {
        return montantStock;
    }

    public String getPhoto() {
        return photo;
    }

    public void ajouterStock(int quantiteAjoutee) {
        this.quantiteStock += quantiteAjoutee;
        this.montantStock = this.quantiteStock * this.prixVente;
    }

    public void diminuerStock(int quantiteVendue) {
        if (quantiteVendue <= this.quantiteStock) {
            this.quantiteStock -= quantiteVendue;
            this.montantStock = this.quantiteStock * this.prixVente;
        }
    }

    @Override
    public String toString() {
        return "[ARTICLE VENTE] " + libelle + " | PU: " + prixVente +
               " | Qté stock: " + quantiteStock + " | Montant: " + montantStock;
    }
}
