

/*
Probleme:


 */


import java.util.Locale;
import java.util.Scanner;


public class EasyCalcGame {

    private static int Rounds = 0;

    public static void sepl(){
        System.out.println("-".repeat(80));
    }

    public static void inCorrect(){
        System.out.println("-".repeat(25));
    }

    public static String playerName() {
        Scanner scanner = new Scanner(System.in);
        String text = "Wer spielt gerade?";
        System.out.println(text);
        System.out.print("> ");
        String playname = scanner.nextLine();

        return playname;
    }

    public static int numberOfGames(Scanner scanner) {
        int numberOfGames = 0;
        boolean help = true;
        String inputNumbG;

        while (help) {
            try {
                System.out.print("Wie viele Spiele möchtest du spielen? --> ");
                inputNumbG = scanner.nextLine();
                numberOfGames = Integer.parseInt(inputNumbG);
                if (numberOfGames > 0)
                    help = false;
                else
                    System.out.println("Bitte gib eine Zahl größer 0 ein! ");
            } catch (NumberFormatException e) {
                System.out.println("\nBitte gib eine Zahl größer 0 ein! ");
            }
        }
        return numberOfGames;
    }

    public static int difficulty() {
        Scanner scanner = new Scanner(System.in);
        int difficulty = 0;
        String input = "";
        String text = "Wähle eine Schwierigkeit: \n" +
                "   1.  Leicht\n" +
                "   2.  Mittel\n" +
                "   3.  Schwer\n" ;
        boolean check = true;
        while (check) {
            sepl();
            System.out.print(text);
            sepl();
            System.out.print("> ");
            input = scanner.nextLine();
            input = input.trim().toLowerCase(Locale.ROOT);
            if (input.equals("1") || input.equals("2") || input.equals("3"))
                check = false;
        }
        sepl();
        if (input.equals("1"))
            difficulty = 1;         //easy

        if (input.equals("2"))
            difficulty = 2;         //middle

        if (input.equals("3"))
            difficulty = 3;         //"hard"

        return difficulty;
    }

    public static void mathsBrain(boolean mathsBrain){       //output if all are correct
        if (mathsBrain) {
            sepl();
            System.out.print("Glückwunsch, du hast alle Ergebnisse richtig!\n");
            sepl();
            sepl();
        }
    }

    public static void main(String[] args) {
        Locale.setDefault(new java.util.Locale("en", "US"));
        Scanner scanner = new Scanner(System.in);
        boolean nochEine = true;

        String playerName = playerName();
        do {

            int difficulty = difficulty();                                  //method for difficulty
            int numberOfGames = numberOfGames(scanner);
            Rounds++;

            boolean[] isCorrect = new boolean[numberOfGames];                //arrays for the objects
            Calc[] calc = new Calc[numberOfGames];
            String[] operations = new String[numberOfGames];
            Participations[] participations = new Participations[numberOfGames];

            sepl();
            System.out.println("    Runde  " + Rounds);
            sepl();

            for (int i = 0; i < numberOfGames; i++) {
                boolean check = true;
                calc[i] = new Calc(difficulty);
                participations[i] = new Participations();             //Time starts

                String input;
                char c = calc[i].getOperator();
                int a = calc[i].getA();
                int b = calc[i].getB();

                int inncercounter = 0;
                double userResult = 0;

                while (check) {

                    if (inncercounter == 0) {
                        System.out.printf("Gib das Ergebnis ein: %d %c %d = ", a, c, b);
                        inncercounter++;
                    } else
                        System.out.printf(" neuer Versuch: %d %c %d = ", a, c, b);

                    input = scanner.nextLine();
                    input = input.trim();
                    try {
                        userResult = Double.parseDouble(input);
                        check = false;
                    } catch (NumberFormatException e) {
                        inCorrect();
                        System.out.println("Bitte gib eine gültige Zahl ein!");
                        inCorrect();
                    }
                }
                participations[i].setTimeB();                                                                      // setting bTime when correct result datatype is input
                isCorrect[i] = participations[i].isCorrect(calc[i].getResult(a, b, c), userResult);                //checks if the result is correct in method in Partici. and adds it to isCorrect ist
                operations[i] = String.format("%d %c %d = %.2f", a, c, b, userResult);                              //adding the whole operation as a String in the array
            }
            System.out.println();


            //output

            double aTime = 0;                                                                                       //average time needed for calcs
            boolean mathsBrain = true;                                                                              //if one result is false , boolean is false
            System.out.println(playerName + ", hier sind deine Ergebnisse!");
            for (int i = 0; i < numberOfGames; i++) {
                System.out.println("Rechnung " + (i + 1) + ":");
                System.out.print("  " + operations[i] + "\n");
                System.out.print("  Korrektheit: " + isCorrect[i] + "\n");
                System.out.printf("  Gebrauchte Zeit: %.2f \n", participations[i].getTimeNeeded());
                aTime += participations[i].getTimeNeeded();
                System.out.println();

                if (!isCorrect[i])
                    mathsBrain = false;

            }
            aTime /= (numberOfGames * 1.0);
            double timeForAllGames = 0.0;
            for (int i = 0; i < numberOfGames; i++){
                timeForAllGames += participations[i].getTimeNeeded();
            }

            sepl();
            System.out.printf("Durchschnittliche Zeit pro Rechnung: %.2f sec \n", aTime);
            sepl();
            System.out.printf("Gesamtzeit für %d Spiele gebrauchte Zeit: %.2f \n",numberOfGames,timeForAllGames);
            sepl();
            mathsBrain(mathsBrain);                     //output if all calcs are correct
            System.out.println("Wenn du das Spiel beenden möchtest\nschreibe ein e und drück die Entertaste,\njede andere Eingabe startet eine neue Runde!");
            String willste = scanner.nextLine();
            willste = willste.trim();
            if (willste.equals("e"))
                nochEine = false;

        } while (nochEine);

        scanner.close();

    }


}
