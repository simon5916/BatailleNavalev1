package bo;

public class Cellule {
    protected String contenu = " . ";
    protected Bateau bateau;

    public Bateau getBateau() {
        return bateau;
    }

    public void setBateau(Bateau bateau) {
        this.bateau = bateau;
    }

    public Cellule() {
    }

    public String GetContenu() {
        if (bateau == null){
            contenu=" ~ ";
        }
        else {
            contenu = " B ";
            if (this.bateau.getNomBateau().equals("test")){
                contenu = " x ";
            } else if (this.bateau.getNomBateau().equals("test0")){
                contenu = " o ";
            }
        }
        return this.contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
}
