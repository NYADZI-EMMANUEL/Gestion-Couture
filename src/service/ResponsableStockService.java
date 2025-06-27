package service;

import model.ResponsableStock;
import java.util.ArrayList;
import java.util.List;

public class ResponsableStockService {
    private List<ResponsableStock> responsables = new ArrayList<>();

    public void ajouter(ResponsableStock r) {
        responsables.add(r);
    }

    public List<ResponsableStock> lister() {
        return responsables;
    }

    public ResponsableStock rechercherParNom(String nom) {
        for (ResponsableStock r : responsables) {
            if (r.getNom().equalsIgnoreCase(nom)) {
                return r;
            }
        }
        return null;
    }

    public boolean supprimer(String nom) {
        ResponsableStock r = rechercherParNom(nom);
        if (r != null) {
            responsables.remove(r);
            return true;
        }
        return false;
    }
}
