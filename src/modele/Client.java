package modele;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client extends Utilisateur {
    private String adresse;
    private final List<Commande> commandes = new ArrayList<>();

    public Client(String nom, String email, String motDePasse, String adresse) {
        super(nom, email, motDePasse);   // appelle le constructeur du parent
        this.adresse = adresse;
    }

    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }

    public List<Commande> getCommandes() {
        return Collections.unmodifiableList(commandes);
    }

    public Commande passerCommande() {
        Commande c = new Commande();
        commandes.add(c);
        return c;
    }

    @Override
    public String getRole() {
        return "CLIENT";
    }
}