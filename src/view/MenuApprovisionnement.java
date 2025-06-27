package view;

import model.Approvisionnement;
import service.ApprovisionnementService;

import java.util.List;
import java.util.Scanner;

public class MenuApprovisionnement {
    private ApprovisionnementService service = new ApprovisionnementService();
    private Scanner scanner = new Scanner(System.in);

    public void afficher() {
        int choix;
        do {
            System.out.println("\n--- MENU APPROVISIONNEMENTS ---");
            System.out.println("1. Enregistrer un approvisionnement");
            System.out.println("2. Lister les approvisionnements");
            System.out.println("3. Rechercher par date");
            System.out.println("4. Rechercher par article");
            System.out.println("5. Rechercher par fournisseur");
            System.out.println("0. Retour au menu principal");

            System.out.print(" Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1 -> enregistrer();
                case 2 -> lister();
                case 3 -> rechercherParDate();
                case 4 -> rechercherParArticle();
                case 5 -> rechercherParFournisseur();
                case 0 -> System.out.println(" Retour au menu principal.");
                default -> System.out.println(" Choix invalide.");
            }
        } while (choix != 0);
    }

    private void enregistrer() {
        System.out.print("Date : ");
        String date = scanner.nextLine();
        System.out.print("Article : ");
        String article = scanner.nextLine();
        System.out.print("Quantité : ");
        int quantite = scanner.nextInt();
        System.out.print("Prix unitaire : ");
        double prixUnitaire = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Observation : ");
        String observation = scanner.nextLine();
        System.out.print("Fournisseur : ");
        String fournisseur = scanner.nextLine();

        Approvisionnement a = new Approvisionnement(date, article, quantite, prixUnitaire, observation, fournisseur);
        service.ajouter(a);
        System.out.println(" Approvisionnement enregistré !");
    }

    private void lister() {
        System.out.println(" Liste des approvisionnements :");
        for (Approvisionnement a : service.lister()) {
            System.out.println(a);
        }
    }

    private void rechercherParDate() {
        System.out.print("Date : ");
        String date = scanner.nextLine();
        List<Approvisionnement> resultats = service.rechercherParDate(date);
        afficherResultats(resultats);
    }

    private void rechercherParArticle() {
        System.out.print("Article : ");
        String article = scanner.nextLine();
        List<Approvisionnement> resultats = service.rechercherParArticle(article);
        afficherResultats(resultats);
    }

    private void rechercherParFournisseur() {
        System.out.print("Fournisseur : ");
        String fournisseur = scanner.nextLine();
        List<Approvisionnement> resultats = service.rechercherParFournisseur(fournisseur);
        afficherResultats(resultats);
    }

    private void afficherResultats(List<Approvisionnement> resultats) {
        if (resultats.isEmpty()) {
            System.out.println(" Aucun résultat trouvé.");
        } else {
            for (Approvisionnement a : resultats) {
                System.out.println(a);
            }
        }
    }
}
