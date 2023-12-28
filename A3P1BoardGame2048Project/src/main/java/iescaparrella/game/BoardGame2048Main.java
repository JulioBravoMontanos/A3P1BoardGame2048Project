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
            str+= " --- --- --- --- \n";
            str += "| ";
            for (int col = 0; col < matriu[row].length; col++) {
                if (matriu[row][col] == 0) str += "\t| ";
                else str += matriu[row][col] + " |";
            }
            str += "\n";
        }
        str+= " --- --- --- --- ";

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

    static void gameMovement(int[][] matriu, char wasd) {
        if (wasd == 'w') {

            //funcio aux moviment cap a dalt
        } else if (wasd == 's') {

            //funcio aux moviment cap a baix
        } else if (wasd == 'a') {

            //funcio aux moviment cap a  esquerra
        } else if (wasd == 'd') {

            //funcio aux moviment cap a dreta
        }
        // funcio que generi el 2 a la matriu si hi ha com a mínim un 0 a la matriu
    }

    static void generate2(int[][] matriu) {
        Random rnd = new Random();
        boolean chivato = false;
        for (int i = 0; i < matriu.length; i++) {
            for (int x = 0; x < matriu[0].length; x++) {
                if (matriu[i][x] == 0) {
                    chivato = true;
                }
            }
        }
    }

    static void movimentDalt(int[][] matriu) {
    }

    static boolean chekOutOfBounds(int[][] matriu, int row, int col) {
        boolean outOfBounds = false;

        if (row < 0 || row > matriu.length - 1 || col < 0 || col > matriu[row].length - 1) {

            outOfBounds = true;
            return outOfBounds;
        }
        return outOfBounds;
    }
}




