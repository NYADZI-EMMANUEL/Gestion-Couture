package model;

public class Gestionnaire extends Utilisateur {
    private String login;
    private String motDePasse;

    public Gestionnaire(String nom, String prenom, String telephone, String adresse, double salaire, String login, String motDePasse) {
        super(nom, prenom, telephone, adresse, salaire);
        this.login = login;
        this.motDePasse = motDePasse;
    }

    public String getLogin() {
        return login;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public boolean seConnecter(String login, String motDePasse) {
        return this.login.equals(login) && this.motDePasse.equals(motDePasse);
    }
}
