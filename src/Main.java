import modele.Commande;
import modele.LigneCommande;
import modele.Produit;

public class Main {
    public static void main(String[] args) {
        Produit pantalon = new Produit("P-001", "Pantalon", 250);
        Produit veste = new Produit("P-002", "Veste", 400);

        Commande cmd = new Commande();
        cmd.ajouterLigne(new LigneCommande(pantalon, 1));
        cmd.ajouterLigne(new LigneCommande(veste, 1));

        System.out.println(cmd);
    }
}