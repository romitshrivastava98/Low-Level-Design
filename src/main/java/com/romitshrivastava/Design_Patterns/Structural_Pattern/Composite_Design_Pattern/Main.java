package com.romitshrivastava.Design_Patterns.Structural_Pattern.Composite_Design_Pattern;

import java.util.ArrayList;
import java.util.List;

// Step 1: Component Interface
interface Employee {
    void showDetails();
}

// Step 2: Leaf Class (Individual Employee)
class IndividualEmployee implements Employee {
    private String name;
    private String position;

    public IndividualEmployee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public void showDetails() {
        System.out.println("Employee: " + name + ", Position: " + position);
    }
}

// Step 3: Composite Class (Manager)
class Manager implements Employee {
    private String name;
    private String position;
    private List<Employee> subordinates = new ArrayList<>();

    public Manager(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public void addEmployee(Employee emp) {
        subordinates.add(emp);
    }

    public void removeEmployee(Employee emp) {
        subordinates.remove(emp);
    }

    @Override
    public void showDetails() {
        System.out.println("\nManager: " + name + ", Position: " + position);
        System.out.println("Subordinates:");
        for (Employee emp : subordinates) {
            emp.showDetails();
        }
    }
}

// Step 4: Client Code
public class Main {
    public static void main(String[] args) {
        // Creating Individual Employees
        Employee emp1 = new IndividualEmployee("John", "Software Engineer");
        Employee emp2 = new IndividualEmployee("Alice", "QA Engineer");
        Employee emp3 = new IndividualEmployee("Bob", "DevOps Engineer");

        // Creating Manager
        Manager manager1 = new Manager("Michael", "Team Lead");
        manager1.addEmployee(emp1);
        manager1.addEmployee(emp2);

        Manager manager2 = new Manager("Sarah", "Engineering Manager");
        manager2.addEmployee(manager1);
        manager2.addEmployee(emp3);

        // Display Organization Structure
        manager2.showDetails();

        System.out.println("\nHEHE\n");
        manager1.showDetails();
        System.out.println("\nHEHE\n");
        emp1.showDetails();
        System.out.println("\nHEHE\n");
    }
}




