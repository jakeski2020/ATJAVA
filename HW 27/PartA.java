import java.time.LocalDate;
import java.time.LocalTime;
public class PartA {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        System.out.println("Today's date is " + currentDate);
        System.out.println("The time is " + currentTime);
    }
}
