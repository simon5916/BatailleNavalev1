package bo;

public class Bateau {
    protected int longueur;
    protected String nomBateau;

    public Bateau(int longueur, String nomBateau) {
        this.longueur = longueur;
        this.nomBateau = nomBateau;
    }

    public int getLongueur() {
        return longueur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    String getNomBateau() {
        return this.nomBateau;
    }
}
