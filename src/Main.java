import modele.Produit;

public class Main {
    public static void main(String[] args) {
        Produit veste = new Produit("P-002", "Veste", 400);
        Produit pantalon = new Produit("P-001", "Pantalon", 250);
        System.out.println(veste);
        System.out.println(pantalon);
        System.out.println(veste.equals(pantalon));
    }
}