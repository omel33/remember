package metodclass;

public class Developer extends Employee {
    private String programmingLanguage;
    private String project;

    public Developer(String name, int employeeId, double salary, String programmingLanguage, String project) {
        super(name, employeeId, salary);
        this.programmingLanguage = programmingLanguage;
        this.project = project;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public String getProject() {
        return project;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Programming Language: " + programmingLanguage);
        System.out.println("Project: " + project);
    }

    @Override
    public double calculateBonus() {
        double bonus= getSalary()*0.12;
        return bonus;
    }
}