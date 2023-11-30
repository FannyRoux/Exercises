package fr.eni.papeterie.bo;

/**
 * @author Fanny Roux
 * 
 */

public abstract class Article {
    private Integer idArticle;
    private String reference;
    private String marque;
    private String designation;
    private float prixUnitaire;
    private int qteStock;

    public Article() {
    }

    public Article(Integer _idArticle, String _marque, String _reference, String _designation, float _prixUnitaire,
            int _qteStock) {
        this.idArticle = _idArticle;
        this.marque = _marque;
        this.reference = _reference;
        this.designation = _designation;
        this.prixUnitaire = _prixUnitaire;
        this.qteStock = _qteStock;
    }

    public Article(String _marque, String _reference, String _designation, float _prixUnitaire, int _qteStock) {
        this.marque = _marque;
        this.reference = _reference;
        this.designation = _designation;
        this.prixUnitaire = _prixUnitaire;
        this.qteStock = _qteStock;
    }

    public Integer getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Integer idArticle) {
        this.idArticle = idArticle;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public float getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(float prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public int getQteStock() {
        return qteStock;
    }

    public void setQteStock(int qteStock) {
        this.qteStock = qteStock;
    }

    public String toString() {
        return String.format(
                "Article [idArticle=%d, reference=%s, marque=%s, designation=%s, prixUnitaire=%.1f, qteStock=%d]",
                idArticle, reference, marque, designation, prixUnitaire, qteStock);
    }

}