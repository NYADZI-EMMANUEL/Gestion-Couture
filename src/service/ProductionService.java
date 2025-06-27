// ====== service/ProductionService.java ======
package service;

import model.Production;
import model.ArticleVente;
import context.AppContext;
import java.util.ArrayList;
import java.util.List;

public class ProductionService {
    private List<Production> productions = new ArrayList<>();

    public void ajouter(Production p) {
        productions.add(p);

        ArticleVente article = AppContext.articleVenteService.rechercher(p.getArticle());
        if (article == null) {
            System.out.println("⚠️ Article introuvable ! Création automatique...");
            article = new ArticleVente(p.getArticle(), 1000, 0, "");
            AppContext.articleVenteService.ajouter(article);
        }

        AppContext.articleVenteService.mettreAJourStock(p.getArticle(), p.getQuantite());
    }

    public List<Production> lister() {
        return productions;
    }

    public List<Production> rechercherParArticle(String article) {
        List<Production> res = new ArrayList<>();
        for (Production p : productions) {
            if (p.getArticle().equalsIgnoreCase(article)) {
                res.add(p);
            }
        }
        return res;
    }

    public List<Production> rechercherParDate(String date) {
        List<Production> res = new ArrayList<>();
        for (Production p : productions) {
            if (p.getDate().equalsIgnoreCase(date)) {
                res.add(p);
            }
        }
        return res;
    }
}
