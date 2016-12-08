
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by RdDvls on 12/8/16.
 */
public class HigherNumberGame {

    public static void clearConsole() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public static int getRandomNumber() {
        return (int) (Math.random() * 10);
    }
    public static void guessHigherNumberGame(Scanner inputScanner, int sleepTime){
        List <String> resultList = new ArrayList<>();
        int winCounter = 0;
        int lossCounter = 0;
        System.out.println("Guess a higher number");
//                Thread.sleep(sleepTime);
        System.out.println("How many rounds would you like to play?");
        int numberOfRounds = Integer.valueOf(inputScanner.nextLine());
        if (numberOfRounds == 0) {
            return;
        }
        while (true) {
            try{
                for (int roundCounter = 0; roundCounter < numberOfRounds; roundCounter++) {
                    System.out.println("Round # " + (roundCounter + 1));
                    System.out.println("Please enter a number between one and ten");
                    int playerNumberChoice = Integer.valueOf(inputScanner.nextLine());
                    //Check that input is between one and ten. If not, prompt user to try again.
                    //                        roundCounter--;
                    if (playerNumberChoice < 0 || playerNumberChoice > 10){
                        throw new Exception();
                    }
                    System.out.println("You chose: " + playerNumberChoice);
                    int computerNumberChoice = getRandomNumber();
                    Thread.sleep(sleepTime);
                    System.out.println("The computer generated: " + computerNumberChoice);
                    Thread.sleep(sleepTime);
                    if (playerNumberChoice > computerNumberChoice) {
                        System.out.println("Congratulations! You win!\n***********\n");
                        resultList.add(roundCounter,"Round #" + (roundCounter + 1) + ": You chose: " + playerNumberChoice + ", the computer chose: " + computerNumberChoice + " ==> You won");
                        winCounter++;
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
                            resultList.add(roundCounter,"Round #" + (roundCounter + 1) + ": You chose: " + playerNumberChoice + ", the computer chose: " + computerNumberChoice + " ==> Tiebreaker ==> Coin flip: You chose: " + coinFlipUserChoice + ", the coin landed on " + coinFlip + " ==> You won");
                            winCounter++;
                        } else if (coinFlipUserChoice.equalsIgnoreCase("heads") && coinFlip > 5) {
                            System.out.println("...the coin has landed on tails!");
                            System.out.println("Fortune is not in your favor. You lose.\n************\n");
                            resultList.add(roundCounter,"Round #" + (roundCounter + 1) + ": You chose: " + playerNumberChoice + ", the computer chose: " + computerNumberChoice + " ==> Tiebreaker ==> Coin flip: You chose: " + coinFlipUserChoice + ", the coin landed on " + coinFlip + " ==> You lost");
                            lossCounter++;
                        } else if (coinFlipUserChoice.equalsIgnoreCase("tails") && coinFlip > 5) {
                            System.out.println("...the coin has landed on tails!");
                            System.out.println("Fortune favors you. You are the winner.\n************\n");
                            resultList.add(roundCounter,"Round #" + (roundCounter + 1) + ": You chose: " + playerNumberChoice + ", the computer chose: " + computerNumberChoice + " ==> Tiebreaker ==> Coin flip: You chose: " + coinFlipUserChoice + ", the coin landed on " + coinFlip + " ==> You won");
                            winCounter++;
                        } else if (coinFlipUserChoice.equalsIgnoreCase("tails") && coinFlip <= 5) {
                            System.out.println("...the coin has landed on heads!");
                            System.out.println("Fortune is not in your favor. You lose.\n************\n");
                            resultList.add(roundCounter,"Round #" + (roundCounter + 1) + ": You chose: " + playerNumberChoice + ", the computer chose: " + computerNumberChoice + " ==> Tiebreaker ==> Coin flip: You chose: " + coinFlipUserChoice + ", the coin landed on " + coinFlip + " ==> You lost");
                            lossCounter++;
                        }
                    } else if (playerNumberChoice < computerNumberChoice) {
                        System.out.println("You lose.\n************\n");
                        resultList.add(roundCounter,"Round #" + (roundCounter + 1) + ": You chose: " + playerNumberChoice + ", the computer chose: " + computerNumberChoice + " ==> You lost");
                        lossCounter++;
                    }
                }
                System.out.println("Thank you for playing!");
                printRoundResults(resultList);
                printTotalResults(winCounter,lossCounter);
                break;
            } catch (Exception numException) {
                    System.out.println("Number must be between one and ten!");
                    System.out.println("Please try again\n\n");
            }
        }

    }
    public static void printRoundResults(List resultList){
        for(int listCounter = 0; listCounter < resultList.size(); listCounter++){
            System.out.println(resultList.subList(listCounter,(listCounter+1)));
        }
    }
    public static void printTotalResults(int winCounter, int lossCounter) {    /*Finish the round results portion before moving to total results*/
        if (winCounter > lossCounter) {
            System.out.println("Summary: You won: " + winCounter + " rounds, the computer won: " + lossCounter + " rounds ==> You are the overall winner");
        } else {
            System.out.println("Summary: You won: " + winCounter + " rounds, the computer won: " + lossCounter + " rounds ==> The computer is the overall winner");
        }
    }

}
