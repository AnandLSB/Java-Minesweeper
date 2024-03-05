
import java.util.Scanner;
import org.apache.commons.lang3.ArrayUtils;

public class GameLogic {
    GameBoard board = new GameBoard();
    GameMain main = new GameMain();
    TextDisplay text = new TextDisplay();
    private static int token = 3;
    private static int moveCount = 0;
    private int clearCount = 15;
    private int[] bomb = new int[10];
    private String[] numArr = new String[25];

    public GameLogic(int[] logicBomb, String[] logicNum) {
        bomb = logicBomb; // passing bombIdx array
        numArr = logicNum; // passing numArr array
    }

    public int getToken() {
        return token;
    }

    public static void setToken(int tokenSet) {
        token = tokenSet;
    }

    public int getMove() {
        return moveCount;
    }

    public static void setMove(int moveSet) {
        moveCount = moveSet;
    }

    public boolean isWin() {
        if (clearCount == 0) {
            return true;
        } else {
            return false;
        }
    }

    // display menu at start of game
    public boolean displayMenu() {
        Scanner userChoice = new Scanner(System.in);
        text.displayTitle();
        text.displayMenu();
        System.out.print("Menu Entry: ");
        if (userChoice.hasNextInt()) {
            int menuEntry;
            int loopIdx = 0;
            do {
                if (loopIdx > 0) {
                    System.out.print("Invalid Entry, Please Try Again: ");
                }
                menuEntry = userChoice.nextInt();
                loopIdx++;

                switch (menuEntry) {
                    case 1:
                        return true;

                    case 2:
                        text.displayRules();
                        System.out.print("\nMenu Entry: ");
                        loopIdx = 0;
                        break;
                    case 0:
                        return false;
                }
            } while (menuEntry != 1 || menuEntry != 0 || loopIdx == 0);
        }
        userChoice.close();
        return false;
    }

    // checking if user hit a bomb
    public void bombCheck(String userMove) {
        System.out.println();
        int moveIdx = 0;
        // find idx of userMove
        for (int i = 0; i < numArr.length; i++) {
            if (userMove.equals(numArr[i])) {
                moveIdx = i;
                break;
            }
        }
        // checks whether user hit a bomb
        boolean hitBomb = ArrayUtils.contains(bomb, moveIdx);
        if (hitBomb == true) {
            System.out.println("**********You Hit a Bomb!**********");
            updateBomb(userMove);
            moveCount++;
            token--;
            if (token == 0) {
                board.displayUpdate();
            }
        } else {
            System.out.println("********Whew! You're Clear!********");
            clearCount--;
            if (isWin() == true) {
                System.out.println("You have won! Congrats :D");
            } else {
                updateBoard(userMove);
                moveCount++;
            }

        }
    }

    // reset game values
    public void resetValues() {
        token = 3;
        moveCount = 0;
        clearCount = 15;
    }

    // update board with empty space
    public void updateBoard(String updateBoard) {
        for (int i = 0; i < numArr.length; i++) {
            if (updateBoard.equals(numArr[i])) {
                numArr[i] = "   ";
                break;
            }
        }
        board.setUpdate(numArr);
    }

    // update board with bomb
    public void updateBomb(String updateBomb) {
        for (int i = 0; i < numArr.length; i++) {
            if (updateBomb.equals(numArr[i])) {
                numArr[i] = "-B-";
                break;
            }
        }
        board.setUpdate(numArr);
    }
}
