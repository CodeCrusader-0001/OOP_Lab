class Employee {
    private String firstName;
    private String lastName;
    private double monthlySalary;

    public Employee(String firstName, String lastName, double monthlySalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        setMonthlySalary(monthlySalary);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        if (monthlySalary > 0) {
            this.monthlySalary = monthlySalary;
        }
    }

    public double getYearlySalary() {
        return monthlySalary * 12;
    }
}

public class EmployeeTest {
    public static void main(String[] args) {
        Employee emp1 = new Employee("John", "Doe", 3000);
        Employee emp2 = new Employee("Jane", "Smith", 4000);

        System.out.printf("Yearly Salary of %s %s: $%.2f%n", emp1.getFirstName(), emp1.getLastName(), emp1.getYearlySalary());
        System.out.printf("Yearly Salary of %s %s: $%.2f%n", emp2.getFirstName(), emp2.getLastName(), emp2.getYearlySalary());

        emp1.setMonthlySalary(emp1.getMonthlySalary() * 1.10);
        emp2.setMonthlySalary(emp2.getMonthlySalary() * 1.10);

        System.out.printf("New Yearly Salary of %s %s: $%.2f%n", emp1.getFirstName(), emp1.getLastName(), emp1.getYearlySalary());
        System.out.printf("New Yearly Salary of %s %s: $%.2f%n", emp2.getFirstName(), emp2.getLastName(), emp2.getYearlySalary());
    }
}
