package iescaparrella.game;

import java.util.Scanner;
import java.util.Random;

/*
 *      Autors:
 *
 *       Júlia Carulla
 *       Julio Bravo
 *
 */

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

                    do {

                        System.out.printf(mostrarMatriu(taula));
                        System.out.println("\nW: amunt, A: esquerra, S: avall, D: dreta, Q: sortir");
                        wasd = keyboard.next().toLowerCase().charAt(0);
                        BoardGame2048Main.gameMovement(taula, wasd);
                        continueishon = BoardGame2048Main.continueishon(taula, wasd);

                    } while (continueishon);
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
                else str += matriu[row][col] + " | ";
            }
            str += "\n";
        }
        str += " --- --- --- --- ";
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
        matriu[rnd.nextInt(TAULER)][rnd.nextInt(TAULER)] = SPAWN;

        //Control per evitar que el segon SPAWN aparegui a la mateixa cel·la que abans
        do {
            rnd1 = rnd.nextInt(TAULER);
            rnd2 = rnd.nextInt(TAULER);
        } while (matriu[rnd1][rnd2] != 0);
        matriu[rnd1][rnd2] = SPAWN;
    }

    static void gameMovement(int[][] matriu, char wasd) {
        int[][] taulaTemp = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};

        if (wasd == 'w') {

            for (int i = 0; i < matriu.length; i++) {
                for (int x = 0; x < matriu[i].length; x++) {
                    if (matriu[i][x] != 0) {
                        if (!chekOutOfBounds(matriu, (i - 1), (x))) {

                            if (matriu[i - 1][x] == matriu[i][x]) taulaTemp[i - 1][x] = matriu[i][x] * 2;
                            else if (taulaTemp[i - 1][x] == 0) taulaTemp[i - 1][x] = matriu[i][x];
                            else taulaTemp[i][x] = matriu[i][x];

                        } else taulaTemp[i][x] = matriu[i][x];
                    }
                }
            }

        } else if (wasd == 's') {

        } else if (wasd == 'a') {

        } else if (wasd == 'd') {

        }
        BoardGame2048Main.actualitzador(matriu, taulaTemp);
    }

    static boolean continueishon(int[][] matriu, char wasd) {
        Random rnd = new Random();
        int rnd1, rnd2;
        boolean continuar = false;

        for (int i = 0; i < matriu.length; i++) {
            for (int x = 0; x < matriu[0].length; x++) {

                if (matriu[i][x] == 0) {
                    continuar = true;

                } else if (matriu[i][x] == GUANYAR) {
                    return false;
                }
            }
        }

        if (continuar) {
            do {
                rnd1 = rnd.nextInt(TAULER);
                rnd2 = rnd.nextInt(TAULER);
            } while (matriu[rnd1][rnd2] != 0);
            matriu[rnd1][rnd2] = SPAWN;
        }

        if (wasd == 'q') return false;
        return continuar;
    }

    static boolean chekOutOfBounds(int[][] matriu, int row, int col) {
        return row < 0 || row > matriu.length - 1 || col < 0 || col > matriu[row].length - 1;
    }

    static void actualitzador(int[][] taula, int[][] taulaTemp) {
        for (int i = 0; i < taulaTemp.length; i++) {
            for (int x = 0; x < taulaTemp[i].length; x++) {
                taula[i][x] = taulaTemp[i][x];
            }
        }
    }
}





