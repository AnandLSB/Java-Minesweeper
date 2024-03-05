
public class TextDisplay {

    public void displayTitle() {
        System.out.println("====================================");
        System.out.println("      @@@@@ @@@@@ @@@@@ @@@@@       ");
        System.out.println("      @     @     @       @         ");
        System.out.println("      @@@@@ @@@@  @  @@   @         ");
        System.out.println("          @ @     @   @   @         ");
        System.out.println("      @@@@@ @@@@@ @@@@@ @@@@@       ");
        System.out.println();
        System.out.println("    @@@@@ @   @ @@@@@ @@@@@ @@@@    ");
        System.out.println("    @     @   @ @     @     @   @   ");
        System.out.println("    @@@@@ @   @ @@@@  @@@@@ @   @   ");
        System.out.println("        @ @@ @@ @     @     @@@@    ");
        System.out.println("    @@@@@ @ @ @ @@@@@ @@@@@ @       ");
        System.out.println("====================================");

    }

    public void displayMenu() {
        System.out.println("          1. START GAME             ");
        System.out.println("          2. DISPLAY RULES          ");
        System.out.println("          0. EXIT GAME              ");
    }

    public void displayRules() {
        System.out.println();
        System.out.println(" GAME RULES:");
        System.out.println(" 1. A player has 3 tokens ");
        System.out.println(" 2. Enter a number between 1-25 to play game");
        System.out.println(" 3. Special key ");
        System.out.println("    a. Enter r to restart game ");
        System.out.println("    b. Enter q to quit the game ");
        System.out.println(" 4. There are 10 hidden bombs, avoid them! 1 token subtracted for each bomb hit ");
        System.out.println(" 5. Successfully selecting the 15 non-bomb spots will win the game! ");
    }

}
