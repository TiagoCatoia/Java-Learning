import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class PaycheckService {
    List<Paycheck> paychecks;

    public PaycheckService() {
        paychecks = new ArrayList<>();
    }

    public void addPaycheck(Employee employee, LocalDate payday) {
        Objects.requireNonNull(employee, "Employee must not be null");
        Objects.requireNonNull(payday, "Payday must not be null");
        employee.paycheckService.paychecks.add(new Paycheck(payday, employee.getSalary()));
        System.out.println(STR."Paycheck added successfully to \{employee.getName()}");
    }

    public void removePaycheck(Employee employee, Paycheck paycheck) {
        Objects.requireNonNull(employee, "Employee must not be null");
        Objects.requireNonNull(paycheck, "Paycheck must not be null");
        employee.paycheckService.paychecks.remove(paycheck);
        System.out.println(STR."Paycheck removed successfully from \{employee.getName()}");
    }

    public Iterator<Paycheck> iteratorPaycheck () {
        return paychecks.iterator();
    }

    public static double getSumOfPaychecks(LocalDate initialDate, LocalDate finalDate, Employee e) {
        Objects.requireNonNull(initialDate, "Initial date must not be null.");
        Objects.requireNonNull(finalDate, "Final date must not be null.");
        Objects.requireNonNull(e, "Employee object must not be null.");

        if (initialDate.isAfter(finalDate)) throw new IllegalArgumentException("Initial date cannot be after final date.");

        double paychecksBetween = 0;
        Iterator<Paycheck> paycheckIterator = e.iteratorPaycheck();
        while (paycheckIterator.hasNext()) {
            Paycheck paycheck = paycheckIterator.next();
            LocalDate payday = paycheck.getPayday();
            if (!payday.isBefore(initialDate) && !payday.isAfter(finalDate)) {
                paychecksBetween += paycheck.getSalary();
            }
        }
        return paychecksBetween;
    }
}
