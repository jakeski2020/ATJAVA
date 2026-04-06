package PartA_Bicycle;
public class GearedBicycle extends Bicycle {

    private int gear;

    public GearedBicycle() {
        gear = 1;
    }

    public void changeGear(int newGear) {
        gear = newGear;
    }

    @Override
    public void brake() {
        int newSpeed = getSpeed() - 2;

        if (newSpeed < 0) {
            newSpeed = 0;
        }

        setSpeed(newSpeed);
    }
}