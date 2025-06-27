package view;

import model.Fournisseur;
import service.FournisseurService;

import java.util.Scanner;

public class MenuFournisseur {
    private FournisseurService service = new FournisseurService();
    private Scanner scanner = new Scanner(System.in);

    public void afficher() {
        int choix;
        do {
            System.out.println("\n--- MENU FOURNISSEUR ---");
            System.out.println("1. Ajouter un fournisseur");
            System.out.println("2. Lister les fournisseurs");
            System.out.println("3. Rechercher par nom");
            System.out.println("4. Rechercher par téléphone");
            System.out.println("5. Supprimer un fournisseur");
            System.out.println("0. Retour au menu principal");

            System.out.print("👉 Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine(); // pour consommer le \n

            switch (choix) {
                case 1 -> ajouter();
                case 2 -> lister();
                case 3 -> rechercherParNom();
                case 4 -> rechercherParTelephone();
                case 5 -> supprimer();
                case 0 -> System.out.println("↩️ Retour au menu principal.");
                default -> System.out.println("❌ Choix invalide.");
            }

        } while (choix != 0);
    }

    private void ajouter() {
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Prénom : ");
        String prenom = scanner.nextLine();
        System.out.print("Téléphone portable : ");
        String telephone = scanner.nextLine();
        System.out.print("Adresse : ");
        String adresse = scanner.nextLine();
        System.out.print("Téléphone fixe : ");
        String fixe = scanner.nextLine();

        Fournisseur f = new Fournisseur(nom, prenom, telephone, adresse, fixe);
        service.ajouter(f);
        System.out.println("✅ Fournisseur ajouté !");
    }

    private void lister() {
        System.out.println("📋 Liste des fournisseurs :");
        for (Fournisseur f : service.lister()) {
            System.out.println(f);
        }
    }

    private void rechercherParNom() {
        System.out.print("Nom à rechercher : ");
        String nom = scanner.nextLine();
        Fournisseur f = service.rechercherParNom(nom);
        if (f != null) {
            System.out.println("✅ Trouvé : " + f);
        } else {
            System.out.println("❌ Aucun fournisseur trouvé.");
        }
    }

    private void rechercherParTelephone() {
        System.out.print("Téléphone à rechercher : ");
        String tel = scanner.nextLine();
        Fournisseur f = service.rechercherParTelephone(tel);
        if (f != null) {
            System.out.println("✅ Trouvé : " + f);
        } else {
            System.out.println("❌ Aucun fournisseur trouvé.");
        }
    }

    private void supprimer() {
        System.out.print("Nom du fournisseur à supprimer : ");
        String nom = scanner.nextLine();
        boolean ok = service.supprimer(nom);
        if (ok) {
            System.out.println("🗑️ Fournisseur supprimé.");
        } else {
            System.out.println("❌ Fournisseur introuvable.");
        }
    }
}
