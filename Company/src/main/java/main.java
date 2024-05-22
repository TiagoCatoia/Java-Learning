import java.time.LocalDate;
import java.util.Scanner;

void main() {
    Company company = new Company();
    Scanner scanner = new Scanner(System.in);

    boolean isRunning = true;
    while (isRunning) {
        System.out.println("\nMenu:");
        System.out.println("1. Hire");
        System.out.println("2. Fire");
        System.out.println("3. Get Employees");
        System.out.println("4. Get Employees by Job Title");
        System.out.println("5. Pay");
        System.out.println("6. Increase Salary");
        System.out.println("7. Average Salary by Job Title");
        System.out.println("8. Average Salary between Dates");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");

        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                System.out.println("Enter employee ID: ");
                String idHire = scanner.nextLine();
                System.out.println("Enter employee name: ");
                String name = scanner.nextLine();
                System.out.println("Enter job title: ");
                String jobTitle = scanner.nextLine();
                System.out.println("Enter salary: ");
                double salary = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Enter date of employment (yyyy-MM-dd): ");
                LocalDate dateOfEmployment = LocalDate.parse(scanner.nextLine());
                company.hire(idHire,name,jobTitle,salary,dateOfEmployment);
                break;
            case 2:
                System.out.println("Enter employee ID: ");
                String idFire = scanner.nextLine();
                company.fire(idFire);
                break;
            case 3:
                company.getEmployees();
                break;
            case 4:
                System.out.println("Enter job title: ");
                String jobTitleEmployees = scanner.nextLine();
                company.getEmployees(jobTitleEmployees);
                break;
            case 5:
                System.out.println("Enter employee ID: ");
                String idToPay = scanner.nextLine();
                company.pay(idToPay);
                break;
            case 6:
                System.out.println("Enter employee ID: ");
                String idIncreaseSalary = scanner.nextLine();
                System.out.println("Enter salary: ");
                double jobTitleIncreaseSalary = scanner.nextDouble();
                company.increaseSalary(idIncreaseSalary, jobTitleIncreaseSalary);
                break;
            case 7:
                System.out.println("Enter job title: ");
                String jobTitleAverageSalary = scanner.nextLine();
                company.averageSalary(jobTitleAverageSalary);
                break;
            case 8:
                System.out.println("Enter initial date (yyyy-MM-dd): ");
                LocalDate initialDate = LocalDate.parse(scanner.nextLine());
                System.out.println("Enter final date (yyyy-MM-dd): ");
                LocalDate finalDate = LocalDate.parse(scanner.nextLine());
                company.averageSalary(initialDate,finalDate);
                break;
            case 0:
                System.out.println("Ending program...");
                isRunning = false;
                scanner.close();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
}