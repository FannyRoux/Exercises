package fr.eni.papeterie.bo;

/**
 * @author Fanny Roux
 * 
 */

public class Ligne {
    protected int qte;
    private Article article;

    public Ligne(Article _article, int _qte){
    this.article = _article;
    this.qte = _qte;

    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public Article getArticle() {
        return article;
    }

    private void setArticle(Article article) {
        this.article = article;
    }

    public float getPrix(){
        return article.getPrixUnitaire();
    }

    public String toString(){
        return String.format("Ligne [ qte=%d, prix=%.1f, article=%s]%n",qte, getPrix(), article.toString());
    }

    
}
