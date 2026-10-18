package modele;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class Utilisateur {
    private static int compteur = 0;

    private final int id;
    private String nom;
    private String email;
    private final String motDePasseHache;

    protected Utilisateur(String nom, String email, String motDePasse) {
        this.id = ++compteur;
        setNom(nom);
        setEmail(email);
        this.motDePasseHache = hacher(motDePasse);
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getEmail() { return email; }

    public void setNom(String nom) {
        if (nom == null || nom.isBlank()) {
            throw new IllegalArgumentException("Le nom est obligatoire");
        }
        this.nom = nom;
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email invalide");
        }
        this.email = email;
    }

    public boolean verifierMotDePasse(String mdp) {
        return motDePasseHache.equals(hacher(mdp));
    }

    // Méthode abstraite : chaque sous-classe doit la définir
    public abstract String getRole();

    public void afficherProfil() {
        System.out.println("[" + getRole() + "] " + nom + " <" + email + ">");
    }

    private static String hacher(String texte) {
        if (texte == null || texte.length() < 6) {
            throw new IllegalArgumentException("Mot de passe trop court (6 caractères minimum)");
        }
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(texte.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-256 indisponible", e);
        }
    }

    @Override
    public String toString() {
        return getRole() + " " + nom + " (" + email + ")";
    }
}