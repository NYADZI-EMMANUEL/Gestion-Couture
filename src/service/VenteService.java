package service;

import model.Vente;
import java.util.ArrayList;
import java.util.List;

public class VenteService {
    private List<Vente> ventes = new ArrayList<>();

    public void ajouter(Vente v) { ventes.add(v); }
    public List<Vente> lister() { return ventes; }
    public List<Vente> rechercherParClient(String client) {
        List<Vente> res = new ArrayList<>();
        for (Vente v : ventes) if (v.getClient().equalsIgnoreCase(client)) res.add(v);
        return res;
    }
    public List<String> listerArticles() {
        List<String> arts = new ArrayList<>();
        for (Vente v : ventes) {
            if (!arts.contains(v.getArticle())) arts.add(v.getArticle());
        }
        return arts;
    }
}
