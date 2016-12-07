import java.util.Scanner;

/**
 * Created by RdDvls on 12/7/16.
 */
public class GameMenu {

    public static int getRandomNumber() {
        return (int) (Math.random() * 10);
    }

    public static void clearConsole() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public static void gameMenu() throws Exception {
        int sleepTime = 2000;
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("************");
        System.out.println("Guess the Number Game");
        System.out.println("************");
        Thread.sleep(sleepTime);
        System.out.println("The goal of this game is to choose a number between one and ten.\nThe computer will then generate a number between one and ten.\nHighest number wins.\n");
        Thread.sleep(sleepTime);
        clearConsole();
        while (true) {
            try {
                clearConsole();
                System.out.println("How many rounds would you like to play?");
                int numberOfRounds = Integer.valueOf(inputScanner.nextLine());
                if (numberOfRounds == 0) {
                    break;
                }
                for (int roundCounter = 0; roundCounter < numberOfRounds; roundCounter++) {
                    System.out.println("Round # " + (roundCounter + 1));
                    System.out.println("Please enter a number between one and ten");
                    int playerNumberChoice = Integer.valueOf(inputScanner.nextLine());
                    //Check that input is between one and ten. If not, prompt user to try again.
                    if (playerNumberChoice < 0 || playerNumberChoice > 10) {
                        throw new Exception("Number must be between 0 and 10!");
                    }
                    System.out.println("You chose: " + playerNumberChoice);
                    int computerNumberChoice = getRandomNumber();
                    Thread.sleep(sleepTime);
                    System.out.println("The computer generated: " + computerNumberChoice);
                    Thread.sleep(sleepTime);
                    if (playerNumberChoice > computerNumberChoice) {
                        System.out.println("Congratulations! You win!\n***********\n");
                    } else if (playerNumberChoice == computerNumberChoice) {   //Tie scenario
                        System.out.println("Same numbers were chosen! There must be a winner!\nA coin toss will settle this nonsense!");
                        int coinFlip = getRandomNumber();
                        System.out.println("Heads or tails?");
                        String coinFlipUserChoice = inputScanner.nextLine();
                        System.out.println("You chose: " + coinFlipUserChoice);
                        System.out.println("Flipping coin...\n");
                        Thread.sleep(sleepTime);
                        if (coinFlipUserChoice.equalsIgnoreCase("heads") && coinFlip <= 5) {
                            System.out.println("...the coin has landed on heads!");
                            Thread.sleep(sleepTime);
                            System.out.println("Fortune favors you. You are the winner.\n************\n");
                        } else if (coinFlipUserChoice.equalsIgnoreCase("heads") && coinFlip > 5) {
                            System.out.println("...the coin has landed on tails!");
                            System.out.println("Fortune is not in your favor. You lose.\n************\n");
                        } else if (coinFlipUserChoice.equalsIgnoreCase("tails") && coinFlip > 5) {
                            System.out.println("...the coin has landed on tails!");
                            System.out.println("Fortune favors you. You are the winner.\n************\n");
                        } else if (coinFlipUserChoice.equalsIgnoreCase("tails") && coinFlip <= 5) {
                            System.out.println("...the coin has landed on heads!");
                            System.out.println("Fortune is not in your favor. You lose.\n************\n");
                        }
                    } else if (playerNumberChoice < computerNumberChoice) {
                        System.out.println("You lose.\n************\n");
                    }
                }
                System.out.println("Would you like to play again? Enter y or n");
                String playAgainChoice = inputScanner.nextLine();
                if (playAgainChoice.equalsIgnoreCase("y")) {
                    clearConsole();
                    GameMenu.gameMenu();
                } else if (playAgainChoice.equalsIgnoreCase("n")) {
                    System.out.println("Thank you for playing");
                }
                break;
            } catch (Exception numException) {
                System.out.println("Number must be between one and ten!");
            }
        }
    }
}
