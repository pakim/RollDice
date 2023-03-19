import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class RollDice {
    int value;
    final int min = 1;
    final int max = 6;

    // RollDice default constructor
    public RollDice() {
        value = 1;
    }

    // RollDice value constructor
    public RollDice(int diceValue) {
        value = diceValue;
    }

    public void randomizeDice() {
        // Current standard way to do random integers
        int random = ThreadLocalRandom.current().nextInt(min, max + 1);
        value = random;
    }

    public static void randomizeAllDice(ArrayList<RollDice> diceList) {
        for(int i = 0; i < diceList.size(); i++) {
            diceList.get(i).randomizeDice();
        }
    }

    // Display specific dice based on the value of the RollDice object
    public void displayDice() {
        switch(value) {
            case 1:
                System.out.println("+-------+");
                System.out.println("|       |");
                System.out.println("|   *   |");
                System.out.println("|       |");
                System.out.println("+-------+");
                break;
            case 2:
                System.out.println("+-------+");
                System.out.println("| *     |");
                System.out.println("|       |");
                System.out.println("|     * |");
                System.out.println("+-------+");
                break;
            case 3:
                System.out.println("+-------+");
                System.out.println("| *     |");
                System.out.println("|   *   |");
                System.out.println("|     * |");
                System.out.println("+-------+");
                break;
            case 4:
                System.out.println("+-------+");
                System.out.println("| *   * |");
                System.out.println("|       |");
                System.out.println("| *   * |");
                System.out.println("+-------+");
                break;
            case 5:
                System.out.println("+-------+");
                System.out.println("| *   * |");
                System.out.println("|   *   |");
                System.out.println("| *   * |");
                System.out.println("+-------+");
                break;
            case 6:
                System.out.println("+-------+");
                System.out.println("| *   * |");
                System.out.println("| *   * |");
                System.out.println("| *   * |");
                System.out.println("+-------+");
                break;
        }
    }

    // Displays all dice
    public static void displayAll(ArrayList<RollDice> diceArray) {
        for(int i = 0; i < diceArray.size(); i++) {
            diceArray.get(i).displayDice();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String reply = "";
        int numDice;
        ArrayList<RollDice> dice = new ArrayList<RollDice>();

        System.out.print("How many dice do you want? (1-5): ");
        // Verifying valid user option for number of dice
        do {
            if(!sc.hasNextInt()) {
                System.out.println("Choose a valid number");
                sc.next();
            }
            else {
                numDice = sc.nextInt();
                if(numDice > 0 && numDice <= 5) {
                    for(int i = 1; i <= numDice; i++) {
                        RollDice newDice = new RollDice(i);
                        dice.add(newDice);
                    }
                    break;
                }
                else {
                    System.out.println("Choose a valid number");
                }
            }
        } while(true);

        RollDice.displayAll(dice);

        do {
            System.out.println("Would you like to roll(y/n)? ");
            reply = sc.next();

            // Simple verification of user input, yes randomizes dice and no exits the program
            if(reply.equals("y") || reply.equals("Y")) {
                RollDice.randomizeAllDice(dice);
                System.out.println("Here are your randomized dice");
                RollDice.displayAll(dice);
            }
            else if(reply.equals("n") || reply.equals("N")) {
                System.exit(0);
            }
        } while(true);
    }
}
