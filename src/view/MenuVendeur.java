package view;

import context.AppContext;
import java.util.List;
import java.util.Scanner;
import model.Vente;

public class MenuVendeur {
    private final Scanner scanner = new Scanner(System.in);

    public void afficher() {
        int choix;
        do {
            System.out.println("\n=== MENU VENDEUR ===");
            System.out.println("1. Enregistrer une vente");
            System.out.println("2. Lister toutes les ventes");
            System.out.println("3. Lister les ventes par client");
            System.out.println("4. Lister les articles de vente");
            System.out.println("0. Retour");
            System.out.print("👉 Choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1 -> enregistrerVente();
                case 2 -> listerVentes();
                case 3 -> ventesParClient();
                case 4 -> listerArticlesVente();
                case 0 -> System.out.println("↩️ Retour au menu précédent.");
                default -> System.out.println("❌ Choix invalide.");
            }
        } while (choix != 0);
    }

    private void enregistrerVente() {
        System.out.print("Date : ");
        String date = scanner.nextLine();
        System.out.print("Nom du client : ");
        String client = scanner.nextLine();
        System.out.print("Article : ");
        String article = scanner.nextLine();
        System.out.print("Quantité : ");
        int qte = scanner.nextInt();
        System.out.print("Prix unitaire : ");
        double prix = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Observation : ");
        String obs = scanner.nextLine();

        Vente v = new Vente(date, article, qte, prix, client, obs);
        AppContext.venteService.ajouter(v);
        System.out.println("✅ Vente enregistrée avec succès !");
    }

    private void ventesParClient() {
        System.out.print("Nom du client : ");
        String nom = scanner.nextLine();
        List<Vente> ventes = AppContext.venteService.rechercherParClient(nom);
        afficherVentes(ventes);
    }

    private void listerVentes() {
        List<Vente> ventes = AppContext.venteService.lister();
        afficherVentes(ventes);
    }

    private void listerArticlesVente() {
        List<String> articles = AppContext.venteService.listerArticles();
        if (articles.isEmpty()) {
            System.out.println("❌ Aucun article trouvé.");
        } else {
            articles.forEach(System.out::println);
        }
    }

    private void afficherVentes(List<Vente> ventes) {
        if (ventes.isEmpty()) {
            System.out.println("❌ Aucune vente trouvée.");
        } else {
            ventes.forEach(System.out::println);
        }
    }
}
