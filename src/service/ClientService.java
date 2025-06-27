package service;

import model.Client;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private List<Client> clients = new ArrayList<>();

    public void ajouter(Client c) { clients.add(c); }
    public List<Client> lister() { return clients; }
    public Client trouverParNom(String nomComplet) {
        return clients.stream()
            .filter(c -> c.getNomComplet().equalsIgnoreCase(nomComplet))
            .findFirst().orElse(null);
    }
    public Client trouverParTelephone(String tel) {
        return clients.stream()
            .filter(c -> c.getTelephone().equalsIgnoreCase(tel))
            .findFirst().orElse(null);
    }
    public boolean supprimer(String nomComplet) {
        return clients.removeIf(c -> c.getNomComplet().equalsIgnoreCase(nomComplet));
    }
    public boolean modifier(String nomComplet, String nouveauTel, String nouvelleAdresse) {
        Client c = trouverParNom(nomComplet);
        if (c != null) {
            clients.remove(c);
            clients.add(new Client(nomComplet.split(" ")[0], nomComplet.split(" ")[1], nouveauTel, nouvelleAdresse, ""));
            return true;
        }
        return false;
    }
}
