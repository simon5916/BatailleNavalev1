package go;

import bo.*;

import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static boolean verificationMissile(Coordonnees coordonneesSelectionCellule, Joueur joueurAttaquer, Joueur joueurAttaquant) {
        boolean verif;
        if (!joueurAttaquer.getGrilleJoueur().Grille1[coordonneesSelectionCellule.x][coordonneesSelectionCellule.y].GetContenu().equals(" ~ ")) {
            verif = true;
            joueurAttaquant.getGrilleAveugleJoueur().Grille1[coordonneesSelectionCellule.x][coordonneesSelectionCellule.y].setContenu(" x ");
        } else {
            verif = false;
            joueurAttaquant.getGrilleAveugleJoueur().Grille1[coordonneesSelectionCellule.x][coordonneesSelectionCellule.y].setContenu(" o ");
        }
        return verif;
    }

    //Grille1[coordonneesSelectionCellule.x][coordonneesSelectionCellule.x] != " ~ "


    public static Coordonnees SelectionCelluleAEliminer() {
        Coordonnees coordonneesSelectionCellule = new Coordonnees();
        Scanner scannerDonneX = new Scanner(System.in);
        System.out.println("Dans quelle ligne souhaitez-vous lancer votre attaque? (1 à 10) ");
        coordonneesSelectionCellule.x = scannerDonneX.nextInt()-1;
        Scanner scannerDonneY = new Scanner(System.in);
        System.out.println("Dans quelle colonne souhaitez-vous lancer votre attaque? (1 à 10) ");
        coordonneesSelectionCellule.y = scannerDonneY.nextInt()-1;
        return coordonneesSelectionCellule;
    }

    public static Coordonnees placementBateaux() {
        Coordonnees placement = null;
        Scanner scannerPosition = new Scanner(System.in);
        System.out.println("Dans quel sens voulez-vous positionner votre bateau ? \n 1: Horizontal \n 2: Vertical");
        int position = scannerPosition.nextInt();
        if (position != 1 && position != 2) {
            System.out.println("Attention ERREUR veuillez séléctionner un des choix proposés plus tôt ");
        } else if (position == 1) {
            placement = placementHorizontal();
        } else if (position == 2) {

            placement = placementVertical();
        }
        placement.position = position;
        return placement;
    }

    public static Coordonnees placementHorizontal() {
        Coordonnees coordonneePlacementHorizontal = new Coordonnees();
        Scanner scannerPositionX = new Scanner(System.in);
        System.out.println("Dans quelle colonne souhaitez-vous mettre la première case de votre bateau? ");
        coordonneePlacementHorizontal.x = scannerPositionX.nextInt();
        Scanner scannerPositionY = new Scanner(System.in);
        System.out.println("Dans quelle ligne souhaitez-vous mettre la première case de votre bateau? (1 à 10) ");
        coordonneePlacementHorizontal.y = scannerPositionY.nextInt();
        return coordonneePlacementHorizontal;
    }

    public static Coordonnees placementVertical() {
        Coordonnees coordonneePlacmementVertical = new Coordonnees();
        Scanner scannerPositionX = new Scanner(System.in);
        System.out.println("Dans quelle colonne souhaitez-vous mettre la première case de votre bateau? (1 à 10)");
        coordonneePlacmementVertical.x = scannerPositionX.nextInt();
        Scanner scannerPositionY = new Scanner(System.in);
        System.out.println("Dans quelle ligne souhaitez-vous mettre la première case de votre bateau? ");
        coordonneePlacmementVertical.y = scannerPositionY.nextInt();
        return coordonneePlacmementVertical;
    }

    public static boolean verificationPositionHorizontalPossible(Bateau bateau, Coordonnees placement, Grille grille) {
        boolean res;
        if (placement.x + bateau.getLongueur() <= 10 && !grille.Grille1[placement.x - 1][placement.y - 1].GetContenu().equals(" B ")) {
            for (int i= 0; i < bateau.getLongueur(); i++){
                if (!grille.Grille1[placement.x - 1][placement.y - 1].GetContenu().equals(" B ")){
                    res = true;
                }
            }
             res = true;
        } else {
            res = false;
        }
        return res;
    }

    public static boolean verificationPositionVerticalPossible(Bateau bateau, Coordonnees placement, Grille grille) {
        boolean res;
        if (placement.y + bateau.getLongueur() <= 10 && !grille.Grille1[placement.x - 1][placement.y - 1].GetContenu().equals(" B ")) {
            for (int i= 0; i < bateau.getLongueur(); i++){
                if (!grille.Grille1[placement.x - 1][placement.y - 1].GetContenu().equals(" B ")){
                    res = true;
                }
            }
            res = true;
        } else {
            res = false;
        }
        return res;
    }






    public static void main(String[] args) {
        int x;
        int JoueurDuTour=0;
        Joueur joueurAttaquant;
        Joueur joueurAttaquer;
        boolean toucher;
        Grille grilleJoueur1 = new Grille();
        Grille grilleJoueur2 = new Grille();
        Grille grilleAveugleJoueur1 = new Grille();
        Grille grilleAveugleJoueur2 = new Grille();
        Jeu monJeu = new Jeu();
        Joueur joueur1 = new Joueur("Joueur1", 5, 17, grilleJoueur1, grilleAveugleJoueur1);
        Joueur joueur2 = new Joueur("Joueur2", 5, 17, grilleJoueur2, grilleAveugleJoueur2);

        //Bateau du premier joueur
        Bateau pa1 = new Bateau(5, "PorteAvion");
        Bateau Cr1 = new Bateau(4, "Croiseur");
        Bateau Ct1 = new Bateau(3, "ContreTorpilleur");
        Bateau Sm1 = new Bateau(3, "SousMarin");
        Bateau To1 = new Bateau(2, "Torpilleur");

        //Bateau du deuxième joueur
        Bateau pa2 = new Bateau(5, "PorteAvion");
        Bateau Cr2 = new Bateau(4, "Croiseur");
        Bateau Ct2 = new Bateau(3, "ContreTorpilleur");
        Bateau Sm2 = new Bateau(3, "SousMarin");
        Bateau To2 = new Bateau(2, "Torpilleur");

        grilleJoueur1.initialisation();
        grilleJoueur2.initialisation();
        grilleAveugleJoueur1.initialisation();
        grilleAveugleJoueur2.initialisation();

        //créer un tableau de bateau et ensuite appeler ce tableau à la place de pa1 juste en dessous
        //créer un deuxième tableau pour le deuxième joueur

        Bateau monTableauDeBateauDuJoueur1[]= new Bateau[joueur1.getNombreBateau()];
        Bateau monTableauDeBateauDuJoueur2[]= new Bateau[joueur2.getNombreBateau()];

        monTableauDeBateauDuJoueur1[1]=pa1;
        monTableauDeBateauDuJoueur1[2]=Cr1;
        monTableauDeBateauDuJoueur1[3]=Ct1;
        monTableauDeBateauDuJoueur1[4]=Sm1;
        monTableauDeBateauDuJoueur1[0]=To1;
        monTableauDeBateauDuJoueur2[1]=pa2;
        monTableauDeBateauDuJoueur2[2]=Cr2;
        monTableauDeBateauDuJoueur2[3]=Ct2;
        monTableauDeBateauDuJoueur2[4]=Sm2;
        monTableauDeBateauDuJoueur2[0]=To2;

        System.out.println("Joueur 1, placez vos bateaux: ");
        grilleJoueur1.ShowList();
        for (int nombreDeBateauPlace = 0; nombreDeBateauPlace < joueur1.getNombreBateau(); nombreDeBateauPlace++) {
            Coordonnees placement = null;
            do {
             placement = placementBateaux();
            }
            while (!verificationPositionHorizontalPossible(monTableauDeBateauDuJoueur1[nombreDeBateauPlace], placement, grilleJoueur1) ||
                    !verificationPositionVerticalPossible(monTableauDeBateauDuJoueur1[nombreDeBateauPlace], placement, grilleJoueur1));

                if (placement.position == 1) {
                    for (int i = 0; i < monTableauDeBateauDuJoueur1[nombreDeBateauPlace].getLongueur(); i++) {
                        grilleJoueur1.Grille1[placement.x - 1][placement.y - 1 + i].setBateau(monTableauDeBateauDuJoueur1[i]);

                    }
                }
                if (placement.position == 2) {
                    for (int i = 0; i < monTableauDeBateauDuJoueur1[nombreDeBateauPlace].getLongueur(); i++) {
                        grilleJoueur1.Grille1[placement.x - 1 + i][placement.y - 1].setBateau(monTableauDeBateauDuJoueur1[i]);
                    }
                }
            grilleJoueur1.ShowList();
        }

        System.out.println("Joueur 2, placez vos bateaux: ");
        grilleJoueur2.ShowList();
        for (int nombreDeBateauPlace = 0; nombreDeBateauPlace < joueur2.getNombreBateau(); nombreDeBateauPlace++) {
            Coordonnees placement = null;
            do {
                placement = placementBateaux();
            }
            while (!verificationPositionHorizontalPossible(monTableauDeBateauDuJoueur2[nombreDeBateauPlace], placement, grilleJoueur2) ||
                    !verificationPositionVerticalPossible(monTableauDeBateauDuJoueur2[nombreDeBateauPlace], placement, grilleJoueur2));

            if (placement.position == 1) {
                for (int i = 0; i < monTableauDeBateauDuJoueur2[nombreDeBateauPlace].getLongueur(); i++) {
                    grilleJoueur2.Grille1[placement.x - 1][placement.y - 1 + i].setBateau(monTableauDeBateauDuJoueur2[i]);

                }
            }
            if (placement.position == 2) {
                for (int i = 0; i < monTableauDeBateauDuJoueur2[nombreDeBateauPlace].getLongueur(); i++) {
                    grilleJoueur2.Grille1[placement.x - 1 + i][placement.y - 1].setBateau(monTableauDeBateauDuJoueur2[i]);
                }
            }
            grilleJoueur2.ShowList();
        }


        joueurAttaquant = joueur1;
        joueurAttaquer = joueur2;






            while (joueurAttaquer.getNombreDeCaseBateauRestantes() != 0){
                do {
                    Coordonnees coordonneesSelectionCellule = SelectionCelluleAEliminer();
                    joueurAttaquant.getGrilleAveugleJoueur().ShowList();
                    if (verificationMissile( coordonneesSelectionCellule,  joueurAttaquer,  joueurAttaquant)){ //si la cellule sélectionée correspond à une cellule pleine dans la grille de l'autre joueur alors ca touche
                        toucher = true;
                        System.out.println("Touché !");
                        System.out.println("Il reste " + joueurAttaquer.getNombreDeCaseBateauRestantes() + " cases bateaux restantes");
                        joueurAttaquant.getGrilleAveugleJoueur().Grille1[coordonneesSelectionCellule.x][coordonneesSelectionCellule.y].setContenu(" x ");
                        joueurAttaquant.getGrilleAveugleJoueur().Grille1[coordonneesSelectionCellule.x][coordonneesSelectionCellule.y].setBateau(new Bateau(1,"test"));
                        joueurAttaquer.setNombreDeCaseBateauRestantes (joueurAttaquer.getNombreDeCaseBateauRestantes() -1);
                        //afficher la grille du joueur attaquant
                        joueurAttaquant.getGrilleAveugleJoueur().ShowList();

                    } else {
                        System.out.println("A l'eau !");
                        System.out.println("Il reste " + joueurAttaquer.getNombreDeCaseBateauRestantes() + " cases bateaux restantes");
                        toucher = false;
                        joueurAttaquant.getGrilleAveugleJoueur().Grille1[coordonneesSelectionCellule.x][coordonneesSelectionCellule.y].setBateau(new Bateau(1,"test0"));
                        joueurAttaquant.getGrilleAveugleJoueur().Grille1[coordonneesSelectionCellule.x][coordonneesSelectionCellule.y].setContenu(" o ");
                        grilleAveugleJoueur1.ShowList();
                    }
                }while (toucher);

                JoueurDuTour += 1;
                if (JoueurDuTour % 2 == 0){
                    joueurAttaquant = joueur1; //Le joueur du tour est le joueur 1
                    joueurAttaquer = joueur2;
                }else {
                    joueurAttaquant = joueur2;//Le joueur du tour est le joueur 2
                    joueurAttaquer = joueur1;
                }

        }
    }
}