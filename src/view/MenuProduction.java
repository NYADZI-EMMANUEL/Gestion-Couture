package view;

import model.Production;
import service.ProductionService;

import java.util.List;
import java.util.Scanner;

public class MenuProduction {
    private ProductionService service = new ProductionService();
    private Scanner scanner = new Scanner(System.in);

    public void afficher() {
        int choix;
        do {
            System.out.println("\n--- MENU GESTION DE LA PRODUCTION ---");
            System.out.println("1. Enregistrer une production");
            System.out.println("2. Lister les productions");
            System.out.println("3. Rechercher par date");
            System.out.println("4. Rechercher par article");
            System.out.println("0. Retour au menu principal");

            System.out.print("👉 Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1 -> enregistrer();
                case 2 -> lister();
                case 3 -> rechercherParDate();
                case 4 -> rechercherParArticle();
                case 0 -> System.out.println("↩️ Retour au menu principal.");
                default -> System.out.println("❌ Choix invalide.");
            }

        } while (choix != 0);
    }

    private void enregistrer() {
        System.out.print("Date : ");
        String date = scanner.nextLine();
        System.out.print("Article produit : ");
        String article = scanner.nextLine();
        System.out.print("Quantité : ");
        int quantite = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Observation : ");
        String observation = scanner.nextLine();

        Production p = new Production(date, article, quantite, observation);
        service.ajouter(p);
        System.out.println("✅ Production enregistrée !");
    }

    private void lister() {
        System.out.println("📋 Liste des productions :");
        for (Production p : service.lister()) {
            System.out.println(p);
        }
    }

    private void rechercherParDate() {
        System.out.print("Date : ");
        String date = scanner.nextLine();
        List<Production> resultats = service.rechercherParDate(date);
        afficherResultats(resultats);
    }

    private void rechercherParArticle() {
        System.out.print("Article : ");
        String article = scanner.nextLine();
        List<Production> resultats = service.rechercherParArticle(article);
        afficherResultats(resultats);
    }

    private void afficherResultats(List<Production> resultats) {
        if (resultats.isEmpty()) {
            System.out.println("❌ Aucun résultat trouvé.");
        } else {
            for (Production p : resultats) {
                System.out.println(p);
            }
        }
    }
}
