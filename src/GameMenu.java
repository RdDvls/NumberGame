import java.util.Scanner;

/**
 * Created by RdDvls on 12/7/16.
 */
public class GameMenu {

//    public static int getRandomNumber() {
//        return (int) (Math.random() * 10);
//    }

    public static void clearConsole() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public static void gameMenu() throws Exception {
        int sleepTime = 2000;
        HigherNumberGame higherNumberGame = new HigherNumberGame();
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("************");
        System.out.println("Guess the Number Game");
        System.out.println("************");
        Thread.sleep(sleepTime);
        clearConsole();
        higherNumberGame.guessHigherNumberGame(inputScanner,sleepTime);
    }
}
