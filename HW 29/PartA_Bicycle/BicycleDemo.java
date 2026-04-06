package PartA_Bicycle;
public class BicycleDemo {
    public static void main(String[] args) {

        Bicycle regularBike = new Bicycle();
        GearedBicycle gearedBike = new GearedBicycle();

        regularBike.setSpeed(10);
        gearedBike.setSpeed(10);

        System.out.println("Initial Speed:");
        System.out.println("Regular Bike: " + regularBike.getSpeed());
        System.out.println("Geared Bike: " + gearedBike.getSpeed());

        regularBike.brake();
        gearedBike.brake();

        System.out.println("\nAfter braking once:");
        System.out.println("Regular Bike: " + regularBike.getSpeed());
        System.out.println("Geared Bike: " + gearedBike.getSpeed());

        regularBike.brake();
        gearedBike.brake();

        System.out.println("\nAfter braking twice:");
        System.out.println("Regular Bike: " + regularBike.getSpeed());
        System.out.println("Geared Bike: " + gearedBike.getSpeed());
    }
}