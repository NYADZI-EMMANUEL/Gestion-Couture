package view;

import java.util.Scanner;
import service.ApprovisionnementService;
import service.ArticleConfectionService;

public class MenuPrincipal {
    private Scanner scanner = new Scanner(System.in);
    private ApprovisionnementService approvisionnementService;
    private ArticleConfectionService articleConfectionService;

    public MenuPrincipal(ApprovisionnementService approvisionnementService, ArticleConfectionService articleConfectionService) {
        this.approvisionnementService = approvisionnementService;
        this.articleConfectionService = articleConfectionService;
    }

    public void afficher() {
        int choix;
        do {
            System.out.println("\n=== MENU PRINCIPAL - GESTIONNAIRE ===");
            System.out.println("1. Gérer les fournisseurs");
            System.out.println("2. Gérer les clients");
            System.out.println("3. Gérer les vendeurs");
            System.out.println("4. Gérer les responsables stock");
            System.out.println("5. Gérer les responsables production");
            System.out.println("6. Gérer les articles de confection");
            System.out.println("7. Gérer les articles de vente");
            System.out.println("8. Gérer les approvisionnements");
            System.out.println("9. Gérer les productions");
            System.out.println("10. Gérer les ventes");
            System.out.println("0. Quitter");
            System.out.print("👉 Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 8 -> menuApprovisionnements();
                case 0 -> System.out.println("👋 Retour au menu principal global.");
                default -> System.out.println("⚠️ Fonctionnalité à implémenter.");
            }
        } while (choix != 0);
    }

    private void menuApprovisionnements() {
        int choix;
        do {
            System.out.println("\n--- MENU APPROVISIONNEMENTS ---");
            System.out.println("1. Enregistrer un approvisionnement");
            System.out.println("2. Lister les approvisionnements");
            System.out.println("3. Rechercher par date");
            System.out.println("4. Rechercher par article");
            System.out.println("5. Rechercher par fournisseur");
            System.out.println("0. Retour au menu principal");
            System.out.print("👉 Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1 -> enregistrerApprovisionnement();
                case 2 -> listerApprovisionnements();
                case 3 -> rechercherParDate();
                case 4 -> rechercherParArticle();
                case 5 -> rechercherParFournisseur();
                case 0 -> System.out.println("↩️ Retour au menu principal.");
                default -> System.out.println("❌ Choix invalide.");
            }
        } while (choix != 0);
    }

    private void enregistrerApprovisionnement() {
        System.out.print("Date : ");
        String date = scanner.nextLine();
        System.out.print("Article : ");
        String article = scanner.nextLine();
        System.out.print("Quantité : ");
        int qte = scanner.nextInt();
        System.out.print("Prix unitaire : ");
        double prix = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Fournisseur : ");
        String fournisseur = scanner.nextLine();
        System.out.print("Observation : ");
        String obs = scanner.nextLine();

        var approvisionnement = new model.Approvisionnement(date, article, qte, prix, fournisseur, obs);
        approvisionnementService.ajouter(approvisionnement);

        boolean maj = articleConfectionService.augmenterStock(article, qte, prix);
        if (maj) {
            System.out.println("✅ Approvisionnement enregistré et stock mis à jour !");
        } else {
            System.out.println("⚠️ Article introuvable ! Création automatique...");
            articleConfectionService.ajouterAutomatiquementArticle(article, prix, qte);
            System.out.println("✅ Article ajouté automatiquement et stock initialisé !");
        }
    }

    private void listerApprovisionnements() {
        System.out.println("📋 Liste des approvisionnements :");
        for (var a : approvisionnementService.lister()) {
            System.out.println(a);
        }
    }

    private void rechercherParDate() {
        System.out.print("Date : ");
        String date = scanner.nextLine();
        var resultats = approvisionnementService.rechercherParDate(date);
        afficherResultats(resultats);
    }

    private void rechercherParArticle() {
        System.out.print("Article : ");
        String article = scanner.nextLine();
        var resultats = approvisionnementService.rechercherParArticle(article);
        afficherResultats(resultats);
    }

    private void rechercherParFournisseur() {
        System.out.print("Fournisseur : ");
        String fournisseur = scanner.nextLine();
        var resultats = approvisionnementService.rechercherParFournisseur(fournisseur);
        afficherResultats(resultats);
    }

    private void afficherResultats(java.util.List<model.Approvisionnement> liste) {
        if (liste.isEmpty()) {
            System.out.println("❌ Aucun résultat trouvé.");
        } else {
            for (var a : liste) {
                System.out.println(a);
            }
        }
    }
}
