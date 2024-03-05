
import java.util.Scanner;

public class GameMain {
    public static void main(String[] args) {

        Scanner userIn = new Scanner(System.in);
        GameBoard display = new GameBoard();
        String[] boardNum = display.getNumArr();
        int[] bomb = display.getBombIdx();
        GameLogic logic = new GameLogic(bomb, boardNum);
        CheckEntry entryCheck = new CheckEntry(boardNum);

        if (logic.displayMenu() == true) { // if user choose to play
            System.out.print("\n            GAME START             ");
            do {
                if (logic.getMove() != 0) {
                    display.displayUpdate();
                } else if (entryCheck.boardReset() == true) {
                    display.displayBoard();
                } else {
                    display.displayBoard();
                }

                System.out.println();
                System.out.println("Lives Left: " + logic.getToken());
                System.out.print("Enter your move: ");

                if (userIn.hasNextInt()) { // User enters int
                    int entryInt = userIn.nextInt();
                    int userMove = entryCheck.validEntry(entryInt);

                    String moveConvert = String.format("%03d", userMove);
                    logic.bombCheck(moveConvert);
                    logic.isWin();
                    userIn.nextLine();
                } else if (userIn.hasNextLine()) { // User enters string
                    String entryString = userIn.nextLine();

                    if (entryString.equals("r") || entryString.equals("R")
                            || entryString.equals("q") || entryString.equals("Q")) {
                        entryCheck.setEntryString(entryString);
                    } else {
                        entryCheck.invalidChar();
                    }
                    continue;
                }

                if (logic.isWin() == true) { // user has won the game
                    System.out.print("Would you like to play again? (Y/N): ");
                    String playAgain = userIn.nextLine();
                    if (playAgain.equals("y") || playAgain.equals("Y")) {
                        logic.resetValues();
                        continue;
                    } else {
                        System.out.println("Thank you for playing!");
                        System.exit(0);
                    }
                }

            } while (logic.getToken() != 0);
            System.out.println("*****Out of tokens! You ded :(*****");
            System.out.println("GAME OVER");
        } else {
            System.out.println("GAME EXIT");
        }
        userIn.close();
    }
}