package metodclass;

public class Manager extends Employee {
    private String department;

    public Manager(String name, int employeeId, double salary, String department) {
        super(name, employeeId, salary);
        this.department = department;
    }
    public String getDepartment() {
        return department;
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Department: " + department);
    }
    @Override
    public double calculateBonus() {
        double bonus= getSalary()*0.15;
        return bonus;
    }
}
