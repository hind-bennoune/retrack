import modele.Client;
import modele.Commande;
import modele.LigneCommande;
import modele.Produit;

public class Main {
    public static void main(String[] args) {
        Client youssef = new Client("Youssef", "youssef@mail.com", "secret123", "Rabat");
        youssef.afficherProfil();

        System.out.println("Bon mot de passe : " + youssef.verifierMotDePasse("secret123"));
        System.out.println("Mauvais mot de passe : " + youssef.verifierMotDePasse("autre123"));

        Produit pantalon = new Produit("P-001", "Pantalon", 250);
        Produit veste = new Produit("P-002", "Veste", 400);

        Commande cmd = youssef.passerCommande();
        cmd.ajouterLigne(new LigneCommande(pantalon, 1));
        cmd.ajouterLigne(new LigneCommande(veste, 1));

        System.out.println(cmd);
    }
}