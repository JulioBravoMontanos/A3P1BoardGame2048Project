package iescaparrella.game;

import java.util.Scanner;
import java.util.Random;


public class BoardGame2048Main {

    static final int TAULER = 4;
    static final int SPAWN = 2;
    static final int GUANYAR = 2048;

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int menu;
        int taula[][] = new int[TAULER][TAULER];

        do {
            System.out.println("Sel·leccioni una opció del menú:");
            System.out.println("~~~~ MENÚ ~~~~\n" +
                    "0. Sortir\n" +
                    "1. Jugar en mode fàcil\n" +
                    "2. Jugar en mode difíıcil\n");
            menu = keyboard.nextInt();

            switch (menu) {
                case 0:
                    System.out.println("Sortint");
                    break;

                case 1:
                    System.out.println("Mode fàcil sel·leccionat.");
                    inicialitzarTaula(taula);
                    System.out.printf(mostrarMatriu(taula));
                    break;

                case 2:
                    System.out.println("Mode difícil sel·leccionat.");
                    inicialitzarTaula(taula);
                    System.out.printf(mostrarMatriu(taula));
                    break;
            }
        } while (menu != 0);
    }

    static String mostrarMatriu(int matriu[][]) {
        String str = "";
        
        for (int row = 0; row < matriu.length; row++) {
            str += "| ";
            for (int col = 0; col < matriu[row].length; col++) {
                if (matriu[row][col] == 0) str += "\t| ";
                else str += matriu[row][col] + " |";

            }
            str += "\n";
        }
        return str;
    }

    static void inicialitzarTaula(int[][] matriu) {
        Random rnd = new Random();
        int rnd1, rnd2;

        //Omplir la taula de 0
        for (int i = 0; i < matriu.length; i++) {
            for (int x = 0; x < matriu[0].length; x++) {
                matriu[i][x] = 0;
            }
        }

        //Afegir primer SPAWN en una cel·la random
        matriu[rnd.nextInt(4)][rnd.nextInt(4)] = SPAWN;

        //Control per evitar que el segon SPAWN a la mateixa cel·la que abans
        do {
            rnd1 = rnd.nextInt(4);
            rnd2 = rnd.nextInt(4);
        } while (matriu[rnd1][rnd2] != 0);
        matriu[rnd1][rnd2] = SPAWN;
    }
}
