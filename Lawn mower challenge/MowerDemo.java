import java.util.Scanner;
import mow.Mower;
import mow.Yard;

public class MowerDemo {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void delay(long mseconds) {
        try {
            Thread.sleep(mseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("InterruptedException received!");
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the height of the yard: ");
            int height = scanner.nextInt();

            System.out.print("Enter the width of the yard: ");
            int width = scanner.nextInt();

            Yard yard = new Yard(height, width);
            Mower mower = new Mower();
            mower.setPosition(1 + height / 2, 1);
            mower.setDirection(1);

            clearScreen();
            yard.printYard(mower);

            while (!mower.isFrontRedBrick(yard)) {
                mower.cutGrass(yard);
                delay(500);
                mower.moveForward();
                clearScreen();
                yard.printYard(mower);
            }

            mower.cutGrass(yard);
            System.out.println("Mowing complete.");
        }
    }
}