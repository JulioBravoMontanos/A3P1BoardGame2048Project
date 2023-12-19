import java.util.Scanner;

public class BoardGame2048Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);


        int menu;

        do {

            System.out.println("Sel.leccioni una opció del menú:");
            System.out.println("~~~~ MEN´U ~~~~\n" +
                    "0. Sortir\n" +
                    "1. Jugar en mode fàcil\n" +
                    "2. Jugar en mode difíıcil\n");
            menu= keyboard.nextInt();

            switch (menu) {
                case 0:

                    System.out.println("Sortint");

                    break;


                case 1:
                    System.out.println("Mode fàcil sel.leccionat.");
                    break;


                case 2:
                    System.out.println("Mode difícil sel.leccionat.");
                    break;

            }



        }while (menu!=0);
    }
}
