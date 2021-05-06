package Miguel.Industries;

import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {
        int secret_number = random.nextInt(100) + 1;
        ArrayList<Integer> user_guesses_number = new ArrayList<>();
        int turn = 7;
        int guess_turn = 1;
        boolean stop = false;
        int user_guess;
        int index = 0;

        //System.out.println(secret_number);
        introMsg(turn);

        do {
            try {
                if (turn == 0) {
                    System.out.println("\nYou have no turn left!");
                    printGuessedNumber(user_guesses_number);
                    stop = true;
                } else {
                    System.out.print("\nWhat is your guess? ");
                    user_guess = scanner.nextInt();
                    scanner.nextLine();
                    user_guesses_number.add(index, user_guess);

                    if (user_guess == secret_number) {
                        System.out.println("You guessed it in " + guess_turn + (guess_turn >= 2 ? " turns." : " turn."));
                        System.out.println("\nWell done!");
                        printGuessedNumber(user_guesses_number);
                        stop = true;
                    } else if (user_guess < secret_number) {
                        turn--;
                        guess_turn++;
                        index++;
                        System.out.println("Your guess of " + user_guess + " is to low!");
                        if(turn > 0)
                            remainingTurnsMsg(turn);
                    } else {
                        turn--;
                        guess_turn++;
                        index++;
                        System.out.println("Your guess of " + user_guess + " is to high!");
                        if(turn > 0)
                            remainingTurnsMsg(turn);
                    }
                }

            } catch (InputMismatchException e) {
                System.err.println("Please input a valid number!");
                scanner.nextLine();
            }
        } while(!stop);
    }

    private static void printGuessedNumber(ArrayList<Integer> user_guesses_number) {
        System.out.println("\nYour Guessed Number");
        System.out.print(user_guesses_number.toString());
    }

    private static void remainingTurnsMsg(int turn) {
        if (turn >= 2)
            System.out.println("You have " + turn + " turns left!");
        else
            System.out.println("You have " + turn + " turn left!");
    }

    private static void introMsg(int turn) {
        System.out.println("I'm thinking of a number between 1 and 100");
        System.out.println("\nYou have " + turn + " turns left!");
    }
}
