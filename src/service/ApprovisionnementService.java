package service;

import model.Approvisionnement;
import java.util.ArrayList;
import java.util.List;

public class ApprovisionnementService {
    private List<Approvisionnement> approvisionnements = new ArrayList<>();

    public void ajouter(Approvisionnement a) {
        approvisionnements.add(a);
    }

    public List<Approvisionnement> lister() {
        return approvisionnements;
    }

    public List<Approvisionnement> rechercherParDate(String date) {
        List<Approvisionnement> resultats = new ArrayList<>();
        for (Approvisionnement a : approvisionnements) {
            if (a.getDate().equalsIgnoreCase(date)) {
                resultats.add(a);
            }
        }
        return resultats;
    }

    public List<Approvisionnement> rechercherParArticle(String article) {
        List<Approvisionnement> resultats = new ArrayList<>();
        for (Approvisionnement a : approvisionnements) {
            if (a.getArticle().equalsIgnoreCase(article)) {
                resultats.add(a);
            }
        }
        return resultats;
    }

    public List<Approvisionnement> rechercherParFournisseur(String fournisseur) {
        List<Approvisionnement> resultats = new ArrayList<>();
        for (Approvisionnement a : approvisionnements) {
            if (a.getFournisseur().equalsIgnoreCase(fournisseur)) {
                resultats.add(a);
            }
        }
        return resultats;
    }
}
