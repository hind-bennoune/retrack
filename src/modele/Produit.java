package modele;

public class Produit {
    private final String reference;
    private String designation;
    private double prix;

    public Produit(String reference, String designation, double prix) {
        this.reference = reference;
        this.designation = designation;
        setPrix(prix);
    }

    public String getReference() { return reference; }
    public String getDesignation() { return designation; }
    public double getPrix() { return prix; }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setPrix(double prix) {
        if (prix < 0) {
            throw new IllegalArgumentException("Le prix ne peut pas être négatif");
        }
        this.prix = prix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produit)) return false;
        Produit autre = (Produit) o;
        return reference.equals(autre.reference);
    }

    @Override
    public int hashCode() {
        return reference.hashCode();
    }

    @Override
    public String toString() {
        return designation + " (" + reference + ") - " + prix + " DH";
    }
}