package metodclass;

public class CompanyApp {
    public static void main(String[] args) {
        Employee employee = new Employee("John", 1, 5000);
        Manager manager = new Manager("Jane", 2, 6000, "Marketing");
        Developer developer = new Developer("Mike", 3, 7000,
                "Java Developer", "Project X");

        employee.displayInfo();

        System.out.println(employee.calculateBonus());

        manager.displayInfo();
        System.out.println(manager.calculateBonus());

        developer.displayInfo();
        System.out.println(developer.calculateBonus());

        developer.setSalary(8000);
        developer.displayInfo();
        System.out.println(developer.calculateBonus());
    }
}
