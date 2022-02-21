package bo;

public class Joueur {
    protected String nomJoueur;
    protected int nombreBateau;
    protected int nombreDeCaseBateauRestantes;
    protected Grille grilleJoueur;
    protected Grille grilleAveugleJoueur;



    public Joueur(String nomJoueur, int nombreBateau, int nombreDeCaseBateauRestantes, Grille grilleJoueur, Grille grilleAveugleJoueur) {
        this.nomJoueur = nomJoueur;
        this.nombreBateau = nombreBateau;
        this.nombreDeCaseBateauRestantes = nombreDeCaseBateauRestantes;
        this.grilleJoueur = grilleJoueur;
        this.grilleAveugleJoueur = grilleAveugleJoueur;
    }

    public int getNombreBateau() {
        return nombreBateau;
    }

    public void setNombreBateau(int nombreBateau) {
        this.nombreBateau = nombreBateau;
    }

    public int getNombreDeCaseBateauRestantes() {
        return nombreDeCaseBateauRestantes;
    }

    public void setNombreDeCaseBateauRestantes(int nombreDeCaseBateauRestantes) {
        this.nombreDeCaseBateauRestantes = nombreDeCaseBateauRestantes;
    }

    public Grille getGrilleJoueur() {
        return grilleJoueur;
    }

    public void setGrilleJoueur(Grille grilleJoueur) {
        this.grilleJoueur = grilleJoueur;
    }

    public Grille getGrilleAveugleJoueur() {
        return grilleAveugleJoueur;
    }

    public void setGrilleAveugleJoueur(Grille grilleAveugleJoueur) {
        this.grilleAveugleJoueur = grilleAveugleJoueur;
    }
}
