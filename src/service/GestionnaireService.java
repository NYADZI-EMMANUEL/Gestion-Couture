package service;

import model.Gestionnaire;

public class GestionnaireService {
    private Gestionnaire gestionnaire;

    public GestionnaireService() {
        // Gestionnaire par défaut (login: admin / mot de passe: admin123)
        gestionnaire = new Gestionnaire(
            "Diallo", "Moustapha", "77 123 45 67", "Dakar", 200000, "admin", "admin123"
        );
    }

    public boolean authentifier(String login, String motDePasse) {
        return gestionnaire.seConnecter(login, motDePasse);
    }

    public Gestionnaire getGestionnaire() {
        return gestionnaire;
    }
}
