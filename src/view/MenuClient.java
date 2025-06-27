package view;

import model.Client;
import service.ClientService;

import java.util.Scanner;

public class MenuClient {
    private ClientService service = new ClientService();
    private Scanner scanner = new Scanner(System.in);

    public void afficher() {
        int choix;
        do {
            System.out.println("\n--- MENU CLIENT ---");
            System.out.println("1. Ajouter un client");
            System.out.println("2. Lister les clients");
            System.out.println("3. Rechercher par nom");
            System.out.println("4. Rechercher par téléphone");
            System.out.println("5. Supprimer un client");
            System.out.println("0. Retour au menu principal");

            System.out.print("👉 Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1 -> ajouter();
                case 2 -> lister();
                case 3 -> rechercherParNom();
                case 4 -> rechercherParTelephone();
                case 5 -> supprimer();
                case 0 -> System.out.println("↩️ Retour au menu principal.");
                default -> System.out.println("❌ Choix invalide.");
            }

        } while (choix != 0);
    }

    private void ajouter() {
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Prénom : ");
        String prenom = scanner.nextLine();
        System.out.print("Téléphone : ");
        String telephone = scanner.nextLine();
        System.out.print("Adresse : ");
        String adresse = scanner.nextLine();
        System.out.print("Observation : ");
        String obs = scanner.nextLine();

        Client client = new Client(nom, prenom, telephone, adresse, obs);
        service.ajouter(client);
        System.out.println("✅ Client ajouté !");
    }

    private void lister() {
        System.out.println("📋 Liste des clients :");
        for (Client c : service.lister()) {
            System.out.println(c);
        }
    }

    private void rechercherParNom() {
        System.out.print("Nom à rechercher : ");
        String nom = scanner.nextLine();
        Client c = service.rechercherParNom(nom);
        if (c != null) {
            System.out.println("✅ Trouvé : " + c);
        } else {
            System.out.println("❌ Aucun client trouvé.");
        }
    }

    private void rechercherParTelephone() {
        System.out.print("Téléphone à rechercher : ");
        String tel = scanner.nextLine();
        Client c = service.rechercherParTelephone(tel);
        if (c != null) {
            System.out.println("✅ Trouvé : " + c);
        } else {
            System.out.println("❌ Aucun client trouvé.");
        }
    }

   private void supprimer() {
        System.out.print("Nom du client à supprimer : ");
        String nom = scanner.nextLine();
        boolean ok = service.supprimer(nom);
        if (ok) {
            System.out.println("🗑️ Client supprimé.");
        } else {
            System.out.println("❌ Client introuvable.");
        }
    }
    
}
