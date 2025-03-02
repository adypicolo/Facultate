import java.util.LinkedList;
import java.util.ArrayList;

interface Visitor {
    public void visit(Employee employee);
    public void visit(Manager manager);
    public void visit(Intern intern);
}

interface Visitable {
    public void accept(Visitor v);
}

class Employee implements Visitable {
    private String name;
    private float salary;
    private float extraHours;

    public Employee(String name, float salary) {
        this.name = name;
        this.salary = salary;
    }

    // Constructor cu 3 parametrii
    public Employee(String name, float salary, float extraHours) {
        this.name = name;
        this.salary = salary;
        this.extraHours = extraHours;
    }

    // Metoda getter extraHours
    public float getExtraHours() {
        return extraHours;
    }

    // Metoda setter extraHours
    public void setExtraHours(float extraHours) {
        this.extraHours = extraHours;
    }

    public String getName() {
        return name;
    }

    public float getSalary() {
        return salary;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}

class Manager extends Employee {
    private float bonus;
    private ArrayList<Visitable> subordinates = new ArrayList<>();

    public Manager(String name, float bonus) {
        super(name, bonus);
        this.bonus = bonus;
    }

    // Constructor cu 3 parametrii
    public Manager(String name, float salary, float bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    // Constructor cu 4 parametrii
    public Manager(String name, float salary, float extraHours, float bonus) {
        super(name, salary, extraHours);
        this.bonus = bonus;
    }

    public float getBonus() {
        return bonus;
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
    }

    public void addSubordinate(Visitable subordinate) {
        subordinates.add(subordinate);
    }

    public ArrayList<Visitable> getSubordinates() {
        return subordinates;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}

class Intern implements Visitable {
    private String name;
    private int internshipDuration;

    public Intern(String name, int internshipDuration) {
        this.name = name;
        this.internshipDuration = internshipDuration;
    }

    public String getName() {
        return name;
    }

    public int getInternshipDuration() {
        return internshipDuration;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class RevenueVisitor implements Visitor {
    public void visit(Employee employee) {
        System.out.println("Angajatul " + employee.getName() + " are venitul " + (employee.getSalary() + 25 * employee.getExtraHours()));
    }

    public void visit(Manager manager) {
        System.out.println("Managerul " + manager.getName() + " are venitul " + (manager.getSalary() + manager.getBonus() + 50 * manager.getExtraHours()));
    }

    public void visit(Intern intern) {
        System.out.println("Internul " + intern.getName() + " nu are venituri.");
    }
}

class BonusPercentageVisitor implements Visitor {
    public void visit(Employee employee) {
        System.out.println("Angajatul " + employee.getName() + " are raportul bonus/salariu = 0");
    }

    public void visit(Manager manager) {
        System.out.println("Managerul " + manager.getName() + " are raportul bonus/salariu = " + (manager.getBonus() / manager.getSalary()));
    }

    public void visit(Intern intern) {
        System.out.println("Internul " + intern.getName() + " nu are raport bonus/salariu.");
    }
}

class MostHardworkingEmployeeFinder implements Visitor {
    private float employeesHours = 0;
    private float managerHours = 0;
    private int employeesCount = 0;
    private int managerCount = 0;

    @Override
    public void visit(Employee employee) {
        employeesHours += employee.getExtraHours();
        employeesCount++;
    }

    @Override
    public void visit(Manager manager) {
        managerHours += manager.getExtraHours();
        managerCount++;
    }

    @Override
    public void visit(Intern intern) {
        // Internii nu contribuie la orele suplimentare în acest vizitator.
    }

    public boolean isBossHardWorking() {
        float employeesAverageHours = employeesCount > 0 ? employeesHours / employeesCount : 0;
        float managersAverageHours = managerCount > 0 ? managerHours / managerCount : 0;
        return employeesAverageHours < managersAverageHours;
    }

    public float getEmployeesAverageHours() {
        return employeesCount > 0 ? employeesHours / employeesCount : 0;
    }

    public float getManagersAverageHours() {
        return managerCount > 0 ? managerHours / managerCount : 0;
    }
}

class TreeVisitor implements Visitor {
    @Override
    public void visit(Employee employee) {
        System.out.println("Vizitat angajatul: " + employee.getName());
    }

    @Override
    public void visit(Manager manager) {
        System.out.println("Vizitat managerul: " + manager.getName());
        for (Visitable subordinate : manager.getSubordinates()) {
            subordinate.accept(this);
        }
    }

    @Override
    public void visit(Intern intern) {
        System.out.println("Vizitat internul: " + intern.getName());
    }
}

public class Test {
    public static void testTask01() {
        LinkedList<Employee> employees = new LinkedList<>();
        employees.add(new Employee("Alice", 20, 10));
        Manager manager;
        employees.add(manager = new Manager("Bob", 1000, 20, 1000));
        manager.setBonus(100);

        Visitor venit = new RevenueVisitor();
        for (Employee e : employees) {
            e.accept(venit);
        }

        Visitor procent = new BonusPercentageVisitor();
        for (Employee e : employees) {
            e.accept(procent);
        }

        // b)
        // Explicație: Dacă accept() nu este suprascrisă în Manager,
        // metoda accept() din Employee va fi folosită,
        // ceea ce duce la apelarea metodei visit(Employee employee)
        // din Visitor pentru Manageri. Astfel, managerii vor fi tratați ca angajați
        // simpli pentru vizitatori.
    }

    public static void testTask02() {
        Manager ceo = new Manager("Seful Mare", 10000, 2, 42);
        Manager adjunct = new Manager("Seful Mic", 9000, 7, 20);
        Employee maria = new Employee("Maria", 2200, 0);
        Employee dan = new Employee("Dan", 2500, 10);
        Employee vasile = new Employee("Vasile", 2000, 5);

        // Construirea structurii arborescente
        ceo.addSubordinate(adjunct);
        ceo.addSubordinate(dan);
        adjunct.addSubordinate(vasile);
        adjunct.addSubordinate(maria);

        // Afișarea subordonaților direcți
        System.out.println("Subordonații direcți ai CEO:");
        for (Visitable subordinate : ceo.getSubordinates()) {
            if (subordinate instanceof Employee) {
                System.out.println(((Employee) subordinate).getName());
            } else if (subordinate instanceof Manager) {
                System.out.println(((Manager) subordinate).getName());
            }
        }

        System.out.println("Subordonații direcți ai adjunctului:");
        for (Visitable subordinate : adjunct.getSubordinates()) {
            if (subordinate instanceof Employee) {
                System.out.println(((Employee) subordinate).getName());
            } else if (subordinate instanceof Manager) {
                System.out.println(((Manager) subordinate).getName());
            }
        }

        // Crearea LinkedList și aplicarea TreeVisitor
        LinkedList<Visitable> totiAngajatii = new LinkedList<>();
        totiAngajatii.add(ceo);
        totiAngajatii.add(adjunct);
        totiAngajatii.add(maria);
        totiAngajatii.add(dan);
        totiAngajatii.add(vasile);

        TreeVisitor tv = new TreeVisitor();
        for (Visitable v : totiAngajatii) {
            v.accept(tv);
        }

        // Aplicarea MostHardworkingEmployeeFinder
        MostHardworkingEmployeeFinder most = new MostHardworkingEmployeeFinder();
        for (Visitable v : totiAngajatii) {
            v.accept(most);
        }

        // Afișarea rezultatului
        System.out.println("Managers are harder working: " + most.isBossHardWorking());
        System.out.println("Managers average hours: " + most.getManagersAverageHours());
        System.out.println("Employees average hours: " + most.getEmployeesAverageHours());
    }

    public static void testTask03() {
            LinkedList<Visitable> persons = new LinkedList<>();
            persons.add(new Employee("Alice", 3000, 15));
            persons.add(new Manager("Bob", 5000, 10, 1000));
            persons.add(new Intern("Charlie", 6));
            persons.add(new Intern("Diana", 3));

            // Vizitator pentru venituri
            Visitor venit = new RevenueVisitor();
            for (Visitable v : persons) {
                v.accept(venit);
            }

            // Vizitator pentru raport bonus
            Visitor procent = new BonusPercentageVisitor();
            for (Visitable v : persons) {
                v.accept(procent);
            }

            // Vizitator pentru cei mai harnici
            MostHardworkingEmployeeFinder most = new MostHardworkingEmployeeFinder();
            for (Visitable v : persons) {
                v.accept(most);
            }

            System.out.println("Managers are harder working: " + most.isBossHardWorking());
    }

    public static void main(String[] args) {
        testTask01();
        testTask02();
        testTask03();
    }
}
