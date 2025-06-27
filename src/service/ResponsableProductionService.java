package service;

import model.ResponsableProduction;
import java.util.ArrayList;
import java.util.List;

public class ResponsableProductionService {
    private List<ResponsableProduction> responsables = new ArrayList<>();

    public void ajouter(ResponsableProduction rp) {
        responsables.add(rp);
    }

    public List<ResponsableProduction> lister() {
        return responsables;
    }

    public ResponsableProduction rechercherParNom(String nom) {
        for (ResponsableProduction rp : responsables) {
            if (rp.getNom().equalsIgnoreCase(nom)) {
                return rp;
            }
        }
        return null;
    }

    public boolean supprimer(String nom) {
        ResponsableProduction rp = rechercherParNom(nom);
        if (rp != null) {
            responsables.remove(rp);
            return true;
        }
        return false;
    }
}
