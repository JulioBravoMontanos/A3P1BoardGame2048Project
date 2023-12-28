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
        boolean continueishon;
        char wasd;

        do {
            System.out.println("\nSel·leccioni una opció del menú:");
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
                    System.out.println("\nW: amunt, A: esquerra, S: avall, D: dreta, Q: sortir");

                    do {


                        wasd = keyboard.next().toLowerCase().charAt(0);
                        BoardGame2048Main.gameMovement(taula, wasd);
                        System.out.printf(mostrarMatriu(taula));
                        System.out.println("\nW: amunt, A: esquerra, S: avall, D: dreta, Q: sortir");
                        continueishon = BoardGame2048Main.continueishon(taula);

                    } while (continueishon || wasd == 'q');
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
            str += " --- --- --- --- \n";
            str += "| ";
            for (int col = 0; col < matriu[row].length; col++) {
                if (matriu[row][col] == 0) str += "\t| ";
                else str += matriu[row][col] + " |";
            }
            str += "\n";
        }
        str += " --- --- --- ---";
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
        int[][] taulaReal = new int[TAULER][TAULER];

        if (wasd == 'w') {

            for (int i = 0; i < matriu.length; i++) {
                for (int x = 0; x < matriu[i].length; x++) {
                    if (matriu[i][x] != 0) {
                        if (!chekOutOfBounds(matriu, (i - 1), (x))) {

                            if (matriu[i - 1][x] == matriu[i][x]) {
                                taulaReal[i - 1][x] = matriu[i][x] * 2;
                            } else {
                                taulaReal[i - 1][x] = matriu[i][x];
                            }
                            matriu[i][x] = 0;
                        }
                    }
                }
            }

            //funcio aux moviment cap a dalt
        } else if (wasd == 's') {

            //funcio aux moviment cap a baix
        } else if (wasd == 'a') {

            //funcio aux moviment cap a  esquerra
        } else if (wasd == 'd') {

            for (int i = 0; i < matriu.length; i++) {
                for (int x = 0; x < matriu[i].length; x++) {
                    if (matriu[i][x] != 0) {
                        if (!chekOutOfBounds(matriu, i, (x - 1))) {

                            if (matriu[i][x - 1] == matriu[i][x]) {
                                taulaReal[i][x - 1] = matriu[i][x] * 2;
                            } else {
                                taulaReal[i][x - 1] = matriu[i][x];
                            }
                            matriu[i][x] = 0;
                        }
                    }
                }
            }
        }
    }

    static boolean continueishon(int[][] matriu) {
        Random rnd = new Random();
        int rnd1 = 0, rnd2 = 0;
        boolean continuar = false;

        for (int i = 0; i < matriu.length; i++) {

            for (int x = 0; x < matriu[0].length; x++) {

                if (matriu[i][x] == 0) {
                    continuar = true;
                    do {
                        rnd1 = rnd.nextInt(4);
                        rnd2 = rnd.nextInt(4);
                    } while (matriu[rnd1][rnd2] != 0);
                    matriu[rnd1][rnd2] = SPAWN;
                } else if (matriu[i][x] == 2048) {
                    continuar = false;
                }
            }
        }
        return continuar;
    }

    static boolean chekOutOfBounds(int[][] matriu, int row, int col) {
        boolean outOfBounds = false;

        if (row < 0 || row > matriu.length - 1 || col < 0 || col > matriu[row].length - 1) {

            outOfBounds = true;
            return outOfBounds;
        }
        return outOfBounds;
    }

    static void resetejador(int[][] taulaTemp) {
        for (int i = 0; i < taulaTemp.length; i++) {
            for (int x = 0; x < taulaTemp[i].length; x++) {
                taulaTemp[i][x] = 0;
            }
        }
    }


}





