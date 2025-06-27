package service;

import model.ArticleConfection;
import java.util.ArrayList;
import java.util.List;

public class ArticleConfectionService {
    private List<ArticleConfection> articlesConfection = new ArrayList<>();

    public ArticleConfection trouverParLibelle(String libelle) {
        for (ArticleConfection a : articlesConfection) {
            if (a.getLibelle().equalsIgnoreCase(libelle)) {
                return a;
            }
        }
        return null;
    }

    public boolean augmenterStock(String libelle, int qte, double prixUnitaire) {
        ArticleConfection article = trouverParLibelle(libelle);
        if (article != null) {
            int nouveauStock = article.getQuantiteStock() + qte;
            article.setQuantiteStock(nouveauStock);
            return true;
        }
        return false;
    }

    public boolean diminuerStock(String libelle, int qte) {
        ArticleConfection article = trouverParLibelle(libelle);
        if (article != null) {
            return article.diminuerStock(qte);
        }
        return false;
    }

    public void ajouterAutomatiquementArticle(String libelle, double prixAchat, int quantite) {
        double montant = prixAchat * quantite;
        ArticleConfection nouvelArticle = new ArticleConfection(libelle, prixAchat, quantite, montant, "photo.jpg");
        articlesConfection.add(nouvelArticle);
    }

    public List<ArticleConfection> lister() {
        return articlesConfection;
    }
}
