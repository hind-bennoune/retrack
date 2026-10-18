package modele;

public class LigneCommande {
    private final Produit produit;
    private int quantite;
    private final double prixUnitaire;

    public LigneCommande(Produit produit, int quantite) {
        if (produit == null) {
            throw new IllegalArgumentException("Le produit est obligatoire");
        }
        this.produit = produit;
        this.prixUnitaire = produit.getPrix();
        setQuantite(quantite);
    }

    public Produit getProduit() { return produit; }
    public int getQuantite() { return quantite; }
    public double getPrixUnitaire() { return prixUnitaire; }

    public void setQuantite(int quantite) {
        if (quantite <= 0) {
            throw new IllegalArgumentException("La quantité doit être positive");
        }
        this.quantite = quantite;
    }

    public double calculerSousTotal() {
        return quantite * prixUnitaire;
    }

    @Override
    public String toString() {
        return quantite + " x " + produit.getDesignation()
                + " = " + calculerSousTotal() + " DH";
    }
}