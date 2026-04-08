import mow.Yard;
import mow.Mower;

public class MowerDemo {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void delay(long mseconds) {
        try {
            Thread.sleep(mseconds);
        } catch (InterruptedException e) {
            System.err.println("InterruptedException received!");
        }
    }

    public static void main(String[] args) {
        // Create a 5x10 lawn
        Yard yard = new Yard(5, 10);

        // Place mower on left side (row 3, column 1), facing right
        Mower mower = new Mower(3, 1, 1);

        // Move mower across the lawn
        while (mower.getCol() <= yard.getLawnWidth()) {
            clearScreen();
            mower.cutGrass(yard);
            yard.print(mower);
            delay(500); // half a second
            mower.moveForward();
        }
    }
}