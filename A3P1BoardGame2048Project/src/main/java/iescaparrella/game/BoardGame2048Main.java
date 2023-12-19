import java.util.Scanner;
import java.util.Random;


public class BoardGame2048Main {

    static final int TAULER = 4;
    static final int SPAWN = 2;
    static final int GUANYAR = 2048;

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
    static void inicialitzarTaula(int [][] matriu){
        Random rnd = new Random;

        for (int i = 0; i < matriu.length; i++){
            for (int x = 0; x < matriu[0].length; x++){
                matriu[i][x] = 0;
            }
        }
        matriu[rnd.newInt(4)][rnd.newInt(4)] = SPAWN;
        //if (matriu[rnd.newInt(4)][rnd.newInt(4)] == 0 );
        //Corregir això
        //matriu[rnd.newInt(4)][rnd.newInt(4)] = if SPAWN;



    }
}
