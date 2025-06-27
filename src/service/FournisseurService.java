package service;

import model.Fournisseur;
import java.util.ArrayList;
import java.util.List;

public class FournisseurService {
    private List<Fournisseur> fournisseurs = new ArrayList<>();

    public void ajouter(Fournisseur f) {
        fournisseurs.add(f);
    }

    public List<Fournisseur> lister() {
        return fournisseurs;
    }

    public Fournisseur rechercherParNom(String nom) {
        for (Fournisseur f : fournisseurs) {
            if (f.getNom().equalsIgnoreCase(nom)) {
                return f;
            }
        }
        return null;
    }

    public Fournisseur rechercherParTelephone(String tel) {
        for (Fournisseur f : fournisseurs) {
            if (f.getTelephone().equals(tel)) {
                return f;
            }
        }
        return null;
    }

    public boolean supprimer(String nom) {
        Fournisseur f = rechercherParNom(nom);
        if (f != null) {
            fournisseurs.remove(f);
            return true;
        }
        return false;
    }
}
