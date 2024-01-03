package iescaparrella.game;

import java.util.Scanner;
import java.util.Random;

/*
 *      Autors:
 *
 *       Júlia Carulla
 *       Julio Bravo
 */

public class BoardGame2048Main {

    static final int TAULER = 4;
    static final int SPAWN = 2;
    static final int GUANYAR = 2048;

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int menu;
        int taula[][] = new int[TAULER][TAULER];
        boolean continuar;
        char moviment;

        do {
            System.out.println("\nSel·lecciona una opció del menú:");
            System.out.println("~~~~ MENÚ ~~~~\n0. Sortir\n1. Jugar en mode fàcil\n2. Jugar en mode difícil\n");
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
                        moviment = keyboard.next().toLowerCase().charAt(0);
                        continuar = BoardGame2048Main.fiPartida(taula, moviment);
                        BoardGame2048Main.gameMovementEZ(taula, moviment);
                        if (continuar) BoardGame2048Main.setSpawn(taula);


                    } while (continuar);
                    System.out.println("S'ha acabat el joc!");
                    break;

                case 2:
                    System.out.println("Mode difícil sel·leccionat.");
                    inicialitzarTaula(taula);

                    do {

                        System.out.printf(mostrarMatriu(taula));
                        System.out.println("\nW: amunt, A: esquerra, S: avall, D: dreta, Q: sortir");
                        moviment = keyboard.next().toLowerCase().charAt(0);
                        continuar = BoardGame2048Main.fiPartida(taula, moviment);
                        BoardGame2048Main.gameMovementDificil(taula, moviment);
                        if (continuar) BoardGame2048Main.setSpawn(taula);

                    } while (continuar);
                    System.out.println("S'ha acabat el joc!");

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

        for (int i = 0; i < matriu.length; i++) {
            for (int x = 0; x < matriu[0].length; x++) {
                matriu[i][x] = 0;
            }
        }

        for (int i = 0; i < SPAWN; i++) {
            BoardGame2048Main.setSpawn(matriu);
        }
    }

    static void gameMovementEZ(int[][] matriu, char wasd) {

        if (wasd == 'w') {
            for (int i = 0; i < matriu.length; i++) {
                for (int x = 0; x < matriu[i].length; x++) {
                    if (matriu[i][x] != 0) {
                        if (checkOutOfBounds(matriu, (i - 1), (x))) {

                            if (matriu[i - 1][x] == matriu[i][x]) {
                                matriu[i - 1][x] = matriu[i][x] * 2;
                                matriu[i][x] = 0;

                            } else if (matriu[i - 1][x] == 0) {
                                matriu[i - 1][x] = matriu[i][x];
                                matriu[i][x] = 0;
                            }
                        }
                    }
                }
            }

        } else if (wasd == 's') {
            for (int i = matriu.length - 1; i >= 0; i--) {
                for (int x = 0; x < matriu[0].length; x++) {
                    if (matriu[i][x] != 0) {
                        if (checkOutOfBounds(matriu, (i + 1), (x))) {

                            if (matriu[i + 1][x] == matriu[i][x]) {
                                matriu[i + 1][x] = matriu[i][x] * 2;
                                matriu[i][x] = 0;

                            } else if (matriu[i + 1][x] == 0) {
                                matriu[i + 1][x] = matriu[i][x];
                                matriu[i][x] = 0;
                            }
                        }
                    }
                }
            }

        } else if (wasd == 'a') {
            for (int i = matriu.length - 1; i >= 0; i--) {
                for (int x = 0; x < matriu.length; x++) {
                    if (matriu[i][x] != 0) {
                        if (checkOutOfBounds(matriu, (i), (x - 1))) {

                            if (matriu[i][x - 1] == matriu[i][x]) {
                                matriu[i][x - 1] = matriu[i][x] * 2;
                                matriu[i][x] = 0;

                            } else if (matriu[i][x - 1] == 0) {
                                matriu[i][x - 1] = matriu[i][x];
                                matriu[i][x] = 0;
                            }
                        }
                    }
                }
            }

        } else if (wasd == 'd') {
            for (int i = 0; i < matriu.length; i++) {
                for (int x = matriu.length - 1; x >= 0; x--) {
                    if (matriu[i][x] != 0) {
                        if (checkOutOfBounds(matriu, (i), (x + 1))) {

                            if (matriu[i][x + 1] == matriu[i][x]) {
                                matriu[i][x + 1] = matriu[i][x] * 2;
                                matriu[i][x] = 0;

                            } else if (matriu[i][x + 1] == 0) {
                                matriu[i][x + 1] = matriu[i][x];
                                matriu[i][x] = 0;
                            }
                        }
                    }
                }
            }
        }
    }

    /*static void gameMovementDificil(int[][] matriu, char wasd) {

        if (wasd == 'w') {
            for (int i = matriu.length - 1; i >= 0; i--) {
                for (int x = 0; x < matriu[i].length; x++) {
                    if (matriu[i][x] != 0) {
                        if (BoardGame2048Main.checkOutOfBounds(matriu, (i - 1), (x))) {

                            if (matriu[i - 1][x] == matriu[i][x]) {
                                matriu[i - 1][x] = matriu[i][x] * 2;
                                matriu[i][x] = 0;
                            } else if (matriu[i - 1][x] == 0) {
                                matriu[i - 1][x] = matriu[i][x];
                                matriu[i][x] = 0;
                            }
                        }
                    }
                }
            }

        } else if (wasd == 's') {

            for (int i = 0; i < matriu.length; i++) {
                for (int x = 0; x < matriu[0].length; x++) {
                    if (matriu[i][x] != 0) {
                        if (BoardGame2048Main.checkOutOfBounds(matriu, (i + 1), (x))) {

                            if (matriu[i + 1][x] == matriu[i][x]) {
                                matriu[i + 1][x] = matriu[i][x] * 2;
                                matriu[i][x] = 0;
                            } else if (matriu[i + 1][x] == 0) {
                                matriu[i + 1][x] = matriu[i][x];
                                matriu[i][x] = 0;
                            }
                        }
                    }
                }
            }

        } else if (wasd == 'a') {

            for (int i = matriu.length - 1; i >= 0; i--) {
                for (int x = matriu.length - 1; x >= 0; x--) {
                    if (matriu[i][x] != 0) {
                        if (BoardGame2048Main.checkOutOfBounds(matriu, (i), (x - 1))) {

                            if (matriu[i][x - 1] == matriu[i][x]) {
                                matriu[i][x - 1] = matriu[i][x] * 2;
                                matriu[i][x] = 0;
                            } else if (matriu[i][x - 1] == 0) {
                                matriu[i][x - 1] = matriu[i][x];
                                matriu[i][x] = 0;
                            }
                        }
                    }
                }
            }

        } else if (wasd == 'd') {

            for (int i = 0; i < matriu.length; i++) {
                for (int x = 0; x < matriu[0].length; x++) {
                    if (matriu[i][x] != 0) {
                        if (BoardGame2048Main.checkOutOfBounds(matriu, (i), (x + 1))) {

                            if (matriu[i][x + 1] == matriu[i][x]) {
                                matriu[i][x + 1] = matriu[i][x] * 2;
                                matriu[i][x] = 0;
                            } else if (matriu[i][x + 1] == 0) {
                                matriu[i][x + 1] = matriu[i][x];
                                matriu[i][x] = 0;
                            }
                        }
                    }
                }
            }
        }
    }*/

    static void gameMovementDificil(int[][] matriu, char wasd) {
        int mov;

        if (wasd == 'w') {
            for (int i = 0; i < matriu.length; i++) {
                for (int x = 0; x < matriu[i].length; x++) {
                    if (matriu[i][x] != 0) {
                        if (i > 0) {

                            mov = BoardGame2048Main.comptadorMoviments(matriu, i, x, -1, 0);

                            if (matriu[i - mov][x] == matriu[i][x]) {
                                matriu[i - mov][x] = matriu[i][x] * 2;
                                matriu[i][x] = 0;

                            } else if (matriu[i - mov][x] == 0) {
                                matriu[i - mov][x] = matriu[i][x];
                                matriu[i][x] = 0;
                            }
                        }
                    }
                }
            }

        } else if (wasd == 's') {
            for (int i = matriu.length - 1; i >= 0; i--) {
                for (int x = 0; x < matriu[0].length; x++) {
                    if (matriu[i][x] != 0) {
                        if (checkOutOfBounds(matriu, (i + 1), (x))) {

                            if (matriu[i + 1][x] == matriu[i][x]) {
                                matriu[i + 1][x] = matriu[i][x] * 2;
                                matriu[i][x] = 0;

                            } else if (matriu[i + 1][x] == 0) {
                                matriu[i + 1][x] = matriu[i][x];
                                matriu[i][x] = 0;
                            }
                        }
                    }
                }
            }

        } else if (wasd == 'a') {
            for (int i = matriu.length - 1; i >= 0; i--) {
                for (int x = 0; x < matriu.length; x++) {
                    if (matriu[i][x] != 0) {
                        if (checkOutOfBounds(matriu, (i), (x - 1))) {

                            if (matriu[i][x - 1] == matriu[i][x]) {
                                matriu[i][x - 1] = matriu[i][x] * 2;
                                matriu[i][x] = 0;

                            } else if (matriu[i][x - 1] == 0) {
                                matriu[i][x - 1] = matriu[i][x];
                                matriu[i][x] = 0;
                            }
                        }
                    }
                }
            }

        } else if (wasd == 'd') {
            for (int i = 0; i < matriu.length; i++) {
                for (int x = matriu.length - 1; x >= 0; x--) {
                    if (matriu[i][x] != 0) {
                        if (checkOutOfBounds(matriu, (i), (x + 1))) {

                            if (matriu[i][x + 1] == matriu[i][x]) {
                                matriu[i][x + 1] = matriu[i][x] * 2;
                                matriu[i][x] = 0;

                            } else if (matriu[i][x + 1] == 0) {
                                matriu[i][x + 1] = matriu[i][x];
                                matriu[i][x] = 0;
                            }
                        }
                    }
                }
            }
        }
    }

    static boolean fiPartida(int[][] matriu, char wasd) {
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
        if (wasd == 'q') return false;
        return continuar;
    }

    static boolean checkOutOfBounds(int[][] matriu, int row, int col) {
        return row >= 0 && row <= matriu.length - 1 && col >= 0 && col <= matriu[row].length - 1;
    }

    static void setSpawn(int[][] matriu) {
        int rnd1, rnd2;
        Random rnd = new Random();

        do {
            rnd1 = rnd.nextInt(TAULER);
            rnd2 = rnd.nextInt(TAULER);

        } while (matriu[rnd1][rnd2] != 0);
        matriu[rnd1][rnd2] = SPAWN;
    }

    static int comptadorMoviments(int[][] matriu, int row, int col, int movRow, int movCol) {
        int movimentsDisponibles = 0;
        int comptadorRow = movRow, comptadorCol = movCol;

        /*if (row == 0 && movRow == -1) return 0;
        if (col == 0 && movCol == -1) return 0;
        if (row == 3 && movRow == 1) return 0;
        if (col == 3 && movCol == 1) return 0;*/

        while (checkOutOfBounds(matriu, (row + comptadorRow), (col + comptadorCol)) && matriu[row + comptadorRow][col + comptadorCol] == 0) {
            movimentsDisponibles++;
            comptadorRow += movRow;
            comptadorCol += movCol;
        }
        return movimentsDisponibles;
    }
}