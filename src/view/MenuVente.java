package view;

import model.Vente;
import service.VenteService;

import java.util.List;
import java.util.Scanner;

public class MenuVente {
    private VenteService service = new VenteService();
    private Scanner scanner = new Scanner(System.in);

    public void afficher() {
        int choix;
        do {
            System.out.println("\n--- MENU GESTION DES VENTES ---");
            System.out.println("1. Enregistrer une vente");
            System.out.println("2. Lister les ventes");
            System.out.println("3. Rechercher par date");
            System.out.println("4. Rechercher par article");
            System.out.println("5. Rechercher par client");
            System.out.println("0. Retour au menu principal");

            System.out.print("👉 Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1 -> enregistrer();
                case 2 -> lister();
                case 3 -> rechercherParDate();
                case 4 -> rechercherParArticle();
                case 5 -> rechercherParClient();
                case 0 -> System.out.println("↩️ Retour au menu principal.");
                default -> System.out.println("❌ Choix invalide.");
            }

        } while (choix != 0);
    }

    private void enregistrer() {
        System.out.print("Date : ");
        String date = scanner.nextLine();
        System.out.print("Article vendu : ");
        String article = scanner.nextLine();
        System.out.print("Quantité : ");
        int quantite = scanner.nextInt();
        System.out.print("Prix unitaire : ");
        double prix = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Observation : ");
        String obs = scanner.nextLine();
        System.out.print("Client : ");
        String client = scanner.nextLine();

        Vente vente = new Vente(date, article, quantite, prix, obs, client);
        service.ajouter(vente);
        System.out.println("✅ Vente enregistrée !");
    }

    private void lister() {
        System.out.println("📋 Liste des ventes :");
        for (Vente v : service.lister()) {
            System.out.println(v);
        }
    }

    private void rechercherParDate() {
        System.out.print("Date : ");
        String date = scanner.nextLine();
        afficherResultats(service.rechercherParDate(date));
    }

    private void rechercherParArticle() {
        System.out.print("Article : ");
        String article = scanner.nextLine();
        afficherResultats(service.rechercherParArticle(article));
    }

    private void rechercherParClient() {
        System.out.print("Client : ");
        String client = scanner.nextLine();
        afficherResultats(service.rechercherParClient(client));
    }

    private void afficherResultats(List<Vente> resultats) {
        if (resultats.isEmpty()) {
            System.out.println("❌ Aucun résultat trouvé.");
        } else {
            for (Vente v : resultats) {
                System.out.println(v);
            }
        }
    }
}
