import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean running = true;
        EmployeeManagementService employeeManagementService = new EmployeeManagementService(new EmployeeRepository());

        while (running) {
            System.out.println("\n1. Hire");
            System.out.println("2. Fire");
            System.out.println("3. Get employees");
            System.out.println("4. Get employees by job title");
            System.out.println("5. Pay");
            System.out.println("6. Increase salary");
            System.out.println("7. Average salary by job title");
            System.out.println("8. Average salary between dates");
            System.out.println("9. Exit");
            System.out.print("Option: ");
            Scanner scanner = new Scanner(System.in);
            String option = scanner.nextLine();
            switch (Integer.parseInt(option)) {
                case 1 -> {
                    System.out.print("Id: ");
                    String id = scanner.nextLine();
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Job title: ");
                    String jobTitle = scanner.nextLine();
                    System.out.print("Salary: ");
                    double salary = scanner.nextDouble();
                    employeeManagementService.hire(id, name, jobTitle, salary);
                }
                case 2 -> {
                    System.out.print("Id: ");
                    String id = scanner.nextLine();
                    employeeManagementService.fire(id);
                }
                case 3 -> {
                    System.out.println("Employees: ");
                    employeeManagementService.getEmployees().forEach(System.out::println);
                }
                case 4 -> {
                    System.out.print("Job title: ");
                    String jobTitle = scanner.nextLine();
                    System.out.println("Employees: ");
                    employeeManagementService.getEmployees(jobTitle).forEach(System.out::println);
                }
                case 5 -> {
                    System.out.print("Id: ");
                    String id = scanner.nextLine();
                    employeeManagementService.pay(id);
                }
                case 6 -> {
                    System.out.print("Id: ");
                    String id = scanner.nextLine();
                    System.out.print("New salary: ");
                    double newSalary = scanner.nextDouble();
                    employeeManagementService.increaseSalary(id, newSalary);
                }
                case 7 -> {
                    System.out.print("Job title: ");
                    String jobTitle = scanner.nextLine();
                    System.out.printf("Average: R$%.2f\n", employeeManagementService.averageSalary(jobTitle));
                }
                case 8 -> {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    System.out.print("Start date: ");
                    LocalDate start = LocalDate.parse(scanner.nextLine(), formatter);
                    System.out.print("End date: ");
                    LocalDate end = LocalDate.parse(scanner.nextLine(), formatter);
                    System.out.printf("Average: R$%.2f\n", employeeManagementService.averageSalary(start, end));
                }
                case 9 -> {
                    running = false;
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }
}
