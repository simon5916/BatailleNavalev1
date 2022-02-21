
package bo;

import java.util.Scanner;

public class Jeu {
    public Jeu() {
    }

    public void NouveauJeu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Voulez-vous lancer une nouvelle partie? y/n");
        String inputResult = sc.nextLine();
    }
}
