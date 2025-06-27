package view;

import java.util.List;
import java.util.Scanner;
import model.Approvisionnement;
import service.ApprovisionnementService;
import service.ArticleConfectionService;

public class MenuResponsableStock {
    private ApprovisionnementService service;
    private ArticleConfectionService articleService;
    private Scanner scanner = new Scanner(System.in);

    public MenuResponsableStock(ApprovisionnementService service, ArticleConfectionService articleService) {
        this.service = service;
        this.articleService = articleService;
    }

    public void afficher() {
        int choix;
        do {
            System.out.println("\n=== MENU RESPONSABLE STOCK ===");
            System.out.println("1. Enregistrer un approvisionnement");
            System.out.println("2. Lister les approvisionnements");
            System.out.println("3. Rechercher par date");
            System.out.println("4. Rechercher par article");
            System.out.println("5. Rechercher par fournisseur");
            System.out.println("0. Retour");
            System.out.print("👉 Choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1 -> enregistrer();
                case 2 -> lister();
                case 3 -> rechercherParDate();
                case 4 -> rechercherParArticle();
                case 5 -> rechercherParFournisseur();
                case 0 -> System.out.println("↩️ Retour au menu précédent.");
                default -> System.out.println("❌ Choix invalide.");
            }
        } while (choix != 0);
    }

    private void enregistrer() {
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

        Approvisionnement a = new Approvisionnement(date, article, qte, prix, fournisseur, obs);
        service.ajouter(a);

        boolean maj = articleService.augmenterStock(article, qte, prix);
        if (maj) {
            System.out.println("✅ Approvisionnement enregistré et stock mis à jour !");
        } else {
            System.out.println("⚠️ Article introuvable ! Création automatique...");
            articleService.ajouterAutomatiquementArticle(article, prix, qte);
            System.out.println("✅ Article ajouté automatiquement et stock initialisé !");
        }
    }

    private void lister() {
        System.out.println("📋 Liste des approvisionnements :");
        for (Approvisionnement a : service.lister()) {
            System.out.println(a);
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

    private void rechercherParFournisseur() {
        System.out.print("Fournisseur : ");
        String fournisseur = scanner.nextLine();
        afficherResultats(service.rechercherParFournisseur(fournisseur));
    }

    private void afficherResultats(List<Approvisionnement> resultats) {
        if (resultats.isEmpty()) {
            System.out.println("❌ Aucun résultat trouvé.");
        } else {
            for (Approvisionnement a : resultats) {
                System.out.println(a);
            }
        }
    }
}
