
import java.util.Scanner;

public class CheckEntry {
    Scanner userIn = new Scanner(System.in);
    private int userEntryInt;
    private String userEntryString;
    GameBoard board = new GameBoard();
    String[] numArr = new String[25];
    private boolean resetStatus;

    // class constructor
    public CheckEntry(String[] boardNum) {
        numArr = boardNum; // passing boardNum array
    }

    // checking string entries
    public void setEntryString(String entryString) {
        if (entryString.equals("r") || entryString.equals("R")) {
            System.out.println("GAME RESET");
            GameLogic.setToken(3);
            GameLogic.setMove(0);
            resetStatus = true;
            boardReset();
        } else if (entryString.equals("q") || entryString.equals("Q")) {
            System.out.println("GAME EXIT");
            System.exit(0);
        }
    }

    // handling method for invalid character entry
    public void invalidChar() {
        do {
            System.out.print("Invalid Entry, Please Enter Char Again: ");
            userEntryString = userIn.nextLine();
        } while (!userEntryString.equals("r") && !userEntryString.equals("R") && !userEntryString.equals("q")
                && !userEntryString.equals("Q"));
        setEntryString(userEntryString);
    }

    public int getUserMove() {
        return userEntryInt;
    }

    // method to change reset state of board
    public boolean boardReset() {
        if (resetStatus == true) {
            return true;
        } else {
            return false;
        }

    }

    // method to check whether entry exists on board
    public int validEntry(int boardEntry) {
        Boolean valid = false;
        int flag = 0;
        while (flag != 1) {
            for (int i = 0; i < numArr.length; i++) {
                if (numArr[i].equals(String.format("%03d", boardEntry))) {
                    valid = true;
                    flag = 1;
                    break;
                } else {
                    continue;
                }
            }
            if (valid == false) {
                System.out.print("Invalid Board Entry, Please Try Again: ");
                boardEntry = userIn.nextInt();
            }
        }
        return boardEntry;
    }
}
