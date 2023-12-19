import java.util.Scanner;

public class BoardGame2048Main {

    static final int TAULER = 4;
    static final int spawn = 2;
    static final int gunayar = 2048;

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int menu;
        int taula [][] = new int[TAULER][TAULER];

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
                    break;

                case 2:
                    System.out.println("Mode difícil sel·leccionat.");
                    break;
            }
        } while (menu != 0);
    }
    static  String mostrarMatriu(int matriu[][]){

    }
    static void inicialitzar taula (int [][] matriu){


    }
}
