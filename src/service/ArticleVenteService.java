package service;

import model.ArticleVente;
import java.util.ArrayList;
import java.util.List;

public class ArticleVenteService {
    private List<ArticleVente> articles = new ArrayList<>();

    public void ajouter(ArticleVente a) {
        articles.add(a);
    }

    public List<ArticleVente> lister() {
        return articles;
    }

    public ArticleVente rechercher(String libelle) {
        for (ArticleVente a : articles) {
            if (a.getLibelle().equalsIgnoreCase(libelle)) {
                return a;
            }
        }
        return null;
    }

    public void mettreAJourStock(String libelle, int quantiteAjoutee) {
        ArticleVente article = rechercher(libelle);
        if (article != null) {
            article.ajouterStock(quantiteAjoutee);
        }
    }

    public void diminuerStock(String libelle, int quantiteVendue) {
        ArticleVente article = rechercher(libelle);
        if (article != null) {
            article.diminuerStock(quantiteVendue);
        }
    }

    public List<String> listerArticles() {
        List<String> noms = new ArrayList<>();
        for (ArticleVente a : articles) {
            noms.add(a.getLibelle());
        }
        return noms;
    }
}
