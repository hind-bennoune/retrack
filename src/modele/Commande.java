package modele;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Commande {
    private static int compteur = 0;

    private final int id;
    private final LocalDate dateCommande;
    private final List<LigneCommande> lignes = new ArrayList<>();

    public Commande() {
        this.id = ++compteur;
        this.dateCommande = LocalDate.now();
    }

    public int getId() { return id; }
    public LocalDate getDateCommande() { return dateCommande; }

    public List<LigneCommande> getLignes() {
        return Collections.unmodifiableList(lignes);
    }

    public void ajouterLigne(LigneCommande ligne) {
        if (ligne == null) {
            throw new IllegalArgumentException("Ligne invalide");
        }
        lignes.add(ligne);
    }

    public double calculerTotal() {
        double total = 0;
        for (LigneCommande l : lignes) {
            total += l.calculerSousTotal();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Commande CMD-" + id + " du " + dateCommande + "\n");
        for (LigneCommande l : lignes) {
            sb.append("  - ").append(l).append("\n");
        }
        sb.append("  Total : ").append(calculerTotal()).append(" DH");
        return sb.toString();
    }
}