package PartA;

import java.util.ArrayList;
import java.util.Scanner;

public class Executive extends Manager {
    private double shares;

    public Executive(String name, double salary, double bonus, double shares) {
        super(name, salary, bonus);
        this.shares = shares;
    }

    public double getShares() {
        return shares;
    }

    public void setShares(double shares) {
        this.shares = shares;
    }

public void displayInfo() {
    super.displayInfo();
    System.out.println("Shares: " + shares);
}

public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();
        while (true) {
            System.out.print("Enter a letter ((E)mployee, (M)anager, or (Q)uit): ");
            String choice = in.nextLine().toLowerCase();
            String name;
            double salary;
            double bonus;
            if (choice.equals("q")) {
                break;
            } else if (choice.equals("e")) {
                System.out.print("Enter name: ");
                name = in.nextLine();
                System.out.print("Enter salary (as a double): ");
                salary = Double.parseDouble(in.nextLine());
                Employee employee = new Employee(name, salary);

                employees.add(employee);
            } else if (choice.equals("m")) {
         
                System.out.print("Enter name: ");
                name = in.nextLine();
                System.out.print("Enter salary (as a double): ");
                salary = Double.parseDouble(in.nextLine());
                System.out.print("Enter bonus (as a double): ");
                bonus = Double.parseDouble(in.nextLine());
                Manager manager = new Manager(name, salary, bonus);

              
                employees.add(manager);
            } else {
                System.out.println("I don't understand your choice.");
            }

            
            System.out.println();
        }

        
        System.out.println();
        System.out.printf("Your company has %d employees.%n", employees.size());
        System.out.println();

        for (Employee employee : employees) {
            employee.displayInfo();
            System.out.println();
        }
        
        in.close();
    }
}

