package fr.eni.papeterie.bo;

/**
 * @author Fanny Roux
 * 
 */

public class Ramette extends Article {
    private int grammage;

    public Ramette(int grammage) {
        this.grammage = grammage;
    }

    public Ramette(Integer _idArticle, String _marque, String _reference, String _designation, float _prixUnitaire,
            int _qteStock, int grammage) {
        super(_idArticle, _marque, _reference, _designation, _prixUnitaire, _qteStock);
        this.grammage = grammage;
    }

    public Ramette(String _marque, String _reference, String _designation, float _prixUnitaire, int _qteStock,
            int grammage) {
        super(_marque, _reference, _designation, _prixUnitaire, _qteStock);
        this.grammage = grammage;
    }

    public int getGrammage() {
        return grammage;
    }

    public void setGrammage(int grammage) {
        this.grammage = grammage;
    }

    public String toString(){
        return String.format("%s Ramette [grammage=%d]",super.toString(),grammage);
    }
}
