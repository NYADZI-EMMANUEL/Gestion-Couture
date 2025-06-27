package view;

import context.AppContext;
import java.util.Scanner;
import service.ApprovisionnementService;
import service.ArticleConfectionService;

public class MenuPrincipalGlobal {
    private Scanner scanner = new Scanner(System.in);

    public void afficher() {
        int choix;
        do {
            System.out.println("\n=== MENU DE CHOIX UTILISATEUR ===");
            System.out.println("1. Gestionnaire");
            System.out.println("2. Responsable de Stock");
            System.out.println("3. Responsable de Production");
            System.out.println("4. Vendeur");
            System.out.println("0. Quitter");
            System.out.print("👉 Choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1 -> {
                    new MenuPrincipal(AppContext.approvisionnementService, AppContext.articleConfectionService).afficher();
                    afficherRetour();
                }
                case 2 -> {
                    new MenuResponsableStock(AppContext.approvisionnementService, AppContext.articleConfectionService).afficher();
                    afficherRetour();
                }
                case 3 -> {
                    new MenuResponsableProduction().afficher();
                    afficherRetour();
                }
                case 4 -> {
                    new MenuVendeur().afficher();

                    afficherRetour();
                }
                case 0 -> System.out.println("👋 Au revoir !");
                default -> System.out.println("❌ Choix invalide !");
            }
        } while (choix != 0);
    }

    private void afficherRetour() {
        System.out.print("\n🔙 Appuyez sur Entrée pour retourner au menu principal...");
        scanner.nextLine();
    }

    public static void main(String[] args) {
        new MenuPrincipalGlobal().afficher();
    }
}
