package view;

import model.ArticleConfection;
import service.ArticleConfectionService;

import java.util.List;
import java.util.Scanner;

public class MenuArticleConfection {
    private final ArticleConfectionService service = new ArticleConfectionService();
    private final Scanner scanner = new Scanner(System.in);

    public void afficher() {
        int choix;
        do {
            System.out.println("\n=== MENU ARTICLES DE CONFECTION ===");
            System.out.println("1. Lister les articles");
            System.out.println("2. Rechercher un article par nom");
            System.out.println("0. Retour");
            System.out.print("👉 Choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1 -> lister();
                case 2 -> rechercher();
                case 0 -> System.out.println("↩️ Retour.");
                default -> System.out.println("❌ Choix invalide !");
            }
        } while (choix != 0);
    }

    private void lister() {
        List<ArticleConfection> articles = service.lister();
        if (articles.isEmpty()) {
            System.out.println("📭 Aucun article disponible.");
        } else {
            for (ArticleConfection a : articles) {
                System.out.println(a);
            }
        }
    }

    private void rechercher() {
        System.out.print("🔍 Libellé de l'article : ");
        String libelle = scanner.nextLine();
        ArticleConfection article = service.trouverParLibelle(libelle);
        if (article == null) {
            System.out.println("❌ Article non trouvé !");
        } else {
            System.out.println(article);
        }
    }
}
