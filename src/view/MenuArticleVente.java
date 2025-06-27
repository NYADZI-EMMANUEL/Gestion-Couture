package view;

import model.ArticleVente;
import service.ArticleVenteService;

import java.util.Scanner;

public class MenuArticleVente {
    private ArticleVenteService service = new ArticleVenteService();
    private Scanner scanner = new Scanner(System.in);

    public void afficher() {
        int choix;
        do {
            System.out.println("\n--- MENU ARTICLES DE VENTE ---");
            System.out.println("1. Ajouter un article");
            System.out.println("2. Lister les articles");
            System.out.println("3. Rechercher un article par libellé");
            System.out.println("4. Supprimer un article");
            System.out.println("0. Retour au menu principal");

            System.out.print("👉 Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1 -> ajouter();
                case 2 -> lister();
                case 3 -> rechercher();
                case 4 -> supprimer();
                case 0 -> System.out.println("↩️ Retour au menu principal.");
                default -> System.out.println("❌ Choix invalide.");
            }

        } while (choix != 0);
    }

    private void ajouter() {
        System.out.print("Libellé : ");
        String libelle = scanner.nextLine();
        System.out.print("Prix de vente : ");
        double prix = scanner.nextDouble();
        System.out.print("Quantité en stock : ");
        int qteStock = scanner.nextInt();
        scanner.nextLine(); // Consommer le \n
        System.out.print("Chemin/photo : ");
        String photo = scanner.nextLine();

        ArticleVente article = new ArticleVente(libelle, prix, qteStock, photo);
        service.ajouter(article);
        System.out.println("✅ Article ajouté !");
    }

    private void lister() {
        System.out.println("📋 Liste des articles de vente :");
        for (ArticleVente a : service.lister()) {
            System.out.println(a);
        }
    }

    private void rechercher() {
        System.out.print("Libellé à rechercher : ");
        String libelle = scanner.nextLine();
        ArticleVente a = service.rechercherParLibelle(libelle);
        if (a != null) {
            System.out.println("✅ Trouvé : " + a);
        } else {
            System.out.println("❌ Aucun article trouvé.");
        }
    }

    private void supprimer() {
        System.out.print("Libellé à supprimer : ");
        String libelle = scanner.nextLine();
        boolean ok = service.supprimer(libelle);
        if (ok) {
            System.out.println("🗑️ Article supprimé.");
        } else {
            System.out.println("❌ Article introuvable.");
        }
    }
}
