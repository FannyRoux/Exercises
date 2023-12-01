package fr.eni.papeterie.bo;

/**
 * @author Fanny Roux
 * 
 */

public class Stylo extends Article {
    private String couleur;

    public Stylo() {
    }

    public Stylo(Integer _idArticle, String _marque, String _reference, String _designation, float _prixUnitaire,
            int _qteStock, String couleur) {
        super(_idArticle, _marque, _reference, _designation, _prixUnitaire, _qteStock);
        this.couleur = couleur;
    }

    public Stylo(String _marque, String _reference, String _designation, float _prixUnitaire, int _qteStock,
            String couleur) {
        super(_marque, _reference, _designation, _prixUnitaire, _qteStock);
        this.couleur = couleur;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String toString(){
        return String.format("%s Stylo [couleur=%s]",super.toString(),couleur);
    }
}
