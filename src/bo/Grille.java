package bo;

public class Grille {
    public Cellule[][] Grille1 = new Cellule[10][10];

    public Grille() {
    }

    public void initialisation() {
        for(int x = 0; x < 10; x++) {
            for(int y = 0; y < 10; y++) {
                this.Grille1[x][y] = new Cellule();
            }
        }

    }

    public void ShowList() {
        for(int x = 0; x < 10; x++) {
            for(int y = 0; y < 10; y++) {
                System.out.print(this.Grille1[x][y].GetContenu());
            }

            System.out.print("\n");
        }

    }
}
