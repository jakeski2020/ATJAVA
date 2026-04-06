package PartA;
 public class Employee {
 private String name;
 private double salary;

 public Employee(String name, double salary) {
    this.name = name;
    this.salary = salary;
    }

public String getName() {
    return name;
    }

public void setName(String newName) {
     name = newName;
    }

public double getSalary() {
    return salary;
    }

public void setSalary(double newSalary) {
    salary = newSalary;
    }

public double getAnnualIncome() {
    return getSalary();
    }

public void displayInfo() {
    System.out.printf("Name   = %s%n  Salary = $%,.2f%n", name, salary);
}
}

