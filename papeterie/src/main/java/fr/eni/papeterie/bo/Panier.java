package fr.eni.papeterie.bo;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Fanny Roux
 * 
 */

public class Panier {
    private float montant = 0f;
    private List<Ligne> lignesPanier = new ArrayList<Ligne>();

    public Panier() {
    }

    public float getMontant() {
        return montant;
    }

    public Ligne getLigne(int index) {
        return lignesPanier.get(index);
    }

    public List<Ligne> getLignesPanier() {
        return lignesPanier;
    }

    public void addLigne(Article article, int qte) {
        lignesPanier.add(new Ligne(article, qte));
    }

    public void updateLigne(int i, int j) {
    }

    public void removeLigne(int i) {
    }

    public String toString() {
        String panier ="";
        for (int i = 0; i < lignesPanier.size(); i++){
            Ligne ligne = lignesPanier.get(i);
            panier += String.format("Ligne %d:     Ligne [qte=%d, prix=%.1f article=%s]%n", i, ligne.getQte(),ligne.getPrix(),ligne.getArticle());
        }
        return String.format("Panier : %n%n%s%n%nValeur du panier : %.1f",panier,montant);

    }

}
