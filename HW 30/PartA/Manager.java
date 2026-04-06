package PartA;
public class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, double bonus) {
        super(name, salary);

        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double newBonus) {
        bonus = newBonus;
    }

    public double getAnnualIncome() {
        return super.getAnnualIncome() + getBonus();
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.printf("  Bonus  = $%,12.2f%n", bonus);
    }
} 

