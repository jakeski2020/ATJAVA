import org.derryfield.math.Algebra;

public class demo {
    public static void main(String[] args) {

        double x = 4;
        double y = 6;

        try {
            double result = Algebra.harmonicMean(x, y);
            System.out.println("Harmonic Mean: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}