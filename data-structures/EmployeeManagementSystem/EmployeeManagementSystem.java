import java.util.Scanner;

class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String toString() {
        return "[" + employeeId + ", " + name + ", " + position + ", ₹" + salary + "]";
    }
}

public class EmployeeManagementSystem {
    static final int MAX = 100;
    static Employee[] employees = new Employee[MAX];
    static int count = 0;

    public static void addEmployee(int id, String name, String position, double salary) {
        if (count < MAX) {
            employees[count++] = new Employee(id, name, position, salary);
        } else {
            System.out.println("Employee array is full.");
        }
    }

    public static Employee searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                return employees[i];
            }
        }
        return null;
    }

    public static void traverseEmployees() {
        if (count == 0) {
            System.out.println("No employees found.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    public static void deleteEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null;
                System.out.println("Employee deleted.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- Employee Management ---");
            System.out.println("1. Add Employee\n2. Search Employee\n3. Traverse Employees\n4. Delete Employee\n5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("ID: "); int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("Position: "); String position = sc.nextLine();
                    System.out.print("Salary: "); double salary = sc.nextDouble();
                    addEmployee(id, name, position, salary);
                    break;
                case 2:
                    System.out.print("Enter ID to search: "); int sid = sc.nextInt();
                    Employee emp = searchEmployee(sid);
                    System.out.println(emp != null ? emp : "Not found");
                    break;
                case 3:
                    traverseEmployees();
                    break;
                case 4:
                    System.out.print("Enter ID to delete: "); int did = sc.nextInt();
                    deleteEmployee(did);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);
        sc.close();
    }
}
