package view;

import context.AppContext;
import java.util.List;
import java.util.Scanner;
import model.Production;

public class MenuResponsableProduction {
    private final Scanner scanner = new Scanner(System.in);

    public void afficher() {
        int choix;
        do {
            System.out.println("\n=== MENU RESPONSABLE DE PRODUCTION ===");
            System.out.println("1. Enregistrer une production");
            System.out.println("2. Lister les productions");
            System.out.println("3. Rechercher les productions par article");
            System.out.println("4. Rechercher les productions par date");
            System.out.println("0. Retour");
            System.out.print("👉 Choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1 -> enregistrerProduction();
                case 2 -> listerProductions();
                case 3 -> rechercherParArticle();
                case 4 -> rechercherParDate();
                case 0 -> System.out.println("↩️ Retour au menu précédent.");
                default -> System.out.println("❌ Choix invalide.");
            }
        } while (choix != 0);
    }

    private void enregistrerProduction() {
        System.out.print("Date : ");
        String date = scanner.nextLine();
        System.out.print("Article : ");
        String article = scanner.nextLine();
        System.out.print("Quantité : ");
        int quantite = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Observation : ");
        String observation = scanner.nextLine();

        Production p = new Production(date, article, quantite, observation);
        AppContext.productionService.ajouter(p);
        System.out.println("✅ Production enregistrée avec succès !");
    }

    private void listerProductions() {
        List<Production> productions = AppContext.productionService.lister();
        afficherProductions(productions);
    }

    private void rechercherParArticle() {
        System.out.print("Article : ");
        String article = scanner.nextLine();
        List<Production> productions = AppContext.productionService.rechercherParArticle(article);
        afficherProductions(productions);
    }

    private void rechercherParDate() {
        System.out.print("Date : ");
        String date = scanner.nextLine();
        List<Production> productions = AppContext.productionService.rechercherParDate(date);
        afficherProductions(productions);
    }

    private void afficherProductions(List<Production> productions) {
        if (productions.isEmpty()) {
            System.out.println("❌ Aucune production trouvée.");
        } else {
            productions.forEach(System.out::println);
        }
    }
}
