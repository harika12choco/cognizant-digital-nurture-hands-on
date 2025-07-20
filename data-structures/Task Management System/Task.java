import java.util.Scanner;

class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }

    public String toString() {
        return "[" + taskId + ", " + taskName + ", " + status + "]";
    }
}

class TaskList {
    Task head;

    public void addTask(int id, String name, String status) {
        Task newTask = new Task(id, name, status);
        if (head == null) head = newTask;
        else {
            Task temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newTask;
        }
    }

    public Task searchTask(int id) {
        Task temp = head;
        while (temp != null) {
            if (temp.taskId == id) return temp;
            temp = temp.next;
        }
        return null;
    }

    public void traverseTasks() {
        Task temp = head;
        if (temp == null) {
            System.out.println("No tasks available.");
            return;
        }
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void deleteTask(int id) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }
        if (head.taskId == id) {
            head = head.next;
            System.out.println("Task deleted.");
            return;
        }
        Task prev = head, curr = head.next;
        while (curr != null && curr.taskId != id) {
            prev = curr;
            curr = curr.next;
        }
        if (curr != null) {
            prev.next = curr.next;
            System.out.println("Task deleted.");
        } else {
            System.out.println("Task not found.");
        }
    }
}

class TaskManagementSystem {
    public static void main(String[] args) {
        TaskList list = new TaskList();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- Task Management Menu ---");
            System.out.println("1. Add Task\n2. Search Task\n3. Traverse Tasks\n4. Delete Task\n5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Task ID: "); int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Task Name: "); String name = sc.nextLine();
                    System.out.print("Status: "); String status = sc.nextLine();
                    list.addTask(id, name, status);
                    break;
                case 2:
                    System.out.print("Enter Task ID to search: "); int sid = sc.nextInt();
                    Task t = list.searchTask(sid);
                    System.out.println(t != null ? t : "Task not found");
                    break;
                case 3:
                    list.traverseTasks();
                    break;
                case 4:
                    System.out.print("Enter Task ID to delete: "); int did = sc.nextInt();
                    list.deleteTask(did);
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
