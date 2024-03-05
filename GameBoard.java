
import java.util.Random;

public class GameBoard {
    private Random randNum = new Random();
    private String[] numArr = new String[25];
    private int[] bombIdx = new int[10];

    public void generateNumArr(String[] numArr) {
        // Generate random unique numbers for numArr
        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = String.format("%03d", randNum.nextInt(25));
            for (int j = 0; j < i; j++) {
                if (numArr[i].equals(numArr[j])) {
                    i--; // if duplicate detected backtrack to previous idx
                    break;
                }
            }
        }
    }

    public String[] getNumArr() {
        return numArr;
    }

    public void generateBombIdx(int[] bombIdx) {
        // Generate random unique numbers for bombIdx
        for (int i = 0; i < 10; i++) {
            bombIdx[i] = randNum.nextInt(25);
            for (int j = 0; j < i; j++) {
                if (bombIdx[i] == bombIdx[j]) {
                    i--;
                    break;
                }
            }
        }
    }

    public int[] getBombIdx() {
        return bombIdx;
    }

    public void setUpdate(String[] updateNum) {
        numArr = updateNum;
    }

    // display updated board
    public void displayUpdate() {
        int idx = 0;
        for (int y = 0; y < 5; y++) {
            System.out.println("===================================");
            for (int x = 0; x < 5; x++) {
                System.out.print("| " + numArr[idx] + " |");
                {
                    idx++;
                }
            }
            System.out.println();
            if (y == 4) {
                System.out.println("===================================");
            }
        }
    }

    public void displayBoard() {

        generateNumArr(numArr); // generating unique numArr
        generateBombIdx(bombIdx); // generating unique bombIdx

        System.out.println();

        // print board
        int idx = 0;
        for (int y = 0; y < 5; y++) {
            System.out.println("===================================");
            for (int x = 0; x < 5; x++) {
                System.out.print("| " + numArr[idx] + " |");
                {
                    idx++;
                }
            }
            System.out.println();
            if (y == 4) {
                System.out.println("===================================");
            }

        }
    }
}
