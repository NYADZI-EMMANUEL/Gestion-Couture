package service;

import model.Vendeur;
import java.util.ArrayList;
import java.util.List;

public class VendeurService {
    private List<Vendeur> vendeurs = new ArrayList<>();

    public void ajouter(Vendeur v) {
        vendeurs.add(v);
    }

    public List<Vendeur> lister() {
        return vendeurs;
    }

    public Vendeur rechercherParNom(String nom) {
        for (Vendeur v : vendeurs) {
            if (v.getNom().equalsIgnoreCase(nom)) {
                return v;
            }
        }
        return null;
    }

    public boolean supprimer(String nom) {
        Vendeur v = rechercherParNom(nom);
        if (v != null) {
            vendeurs.remove(v);
            return true;
        }
        return false;
   
    }

    
}
