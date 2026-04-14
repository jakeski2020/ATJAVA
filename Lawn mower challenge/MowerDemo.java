import mow.Yard;
import mow.Mower;
import java.util.Scanner;
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
        clearScreen();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the height of the lawn: ");
        int height = scanner.nextInt();
        System.out.print("Enter the width of the lawn: ");
        int width = scanner.nextInt();
        Yard yard = new Yard(height, width);
        Mower mower = new Mower(1, 1, 1);
        mower.randomize(yard);
        boolean mowing = true;
        while (mowing) {
            clearScreen();
            yard.print(mower);
            delay(200);
            mowing = mower.updateMower(yard);
        }
        clearScreen();
        yard.print(mower);
        System.out.println("\nLawn mowing complete!");
        scanner.close();
    }
}