import Firm.Firm;
import Human.Human;
import Human.Position;
import Human.Sex;
import Human.Worker;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        Worker[] firmWorkers = {
                new Worker(new Human("Ivan", 24, Sex.MALE), Position.EMPLOYEE, 1200, 1),
                new Worker(new Human("Olga", 29, Sex.FEMALE), Position.EMPLOYEE, 1400, 2),
                new Worker(new Human("Alexey", 31, Sex.MALE), Position.DIRECTOR, 2500, 4),
                new Worker(new Human("Sergey", 33, Sex.MALE), Position.DIRECTOR, 3100, 6)
        };
        Firm firm = new Firm("My Firm", firmWorkers);
        boolean exit = false;
        while (!exit) {
            Scanner sc = new Scanner(System.in);

            out.println("Firm: " + firm.GetName() + "\n");
            out.println("1 - get worker list;");
            out.println("2 - add worker;");
            out.println("3 - remove worker;");
            out.println("4 - calc total salary;");
            out.println("0 - Exit;\n");
            out.print("Enter action:");
            int action = sc.nextInt();
            switch (action) {
                case 0:
                    exit = true;
                    out.println("Bye!");
                    break;
                case 1:
                    workerMenu(firm);
                    break;
                case 2:
                    addWorker(firm);
                    break;
                case 3:
                    removeWorker(firm);
                    break;
                case 4:
                    totalSalary(firm);
                    break;
                default:
                    out.println("Unexpected value: " + action);
            }
        }
    }

    public static void workerMenu(Firm firm) {
        out.println(firm.GetName() + " workers:\n");
        List<Worker> workers = firm.GetWorkers();
        out.println("Id\tName\tSex\t\tAge\tPosition\tSalary");
        workers.forEach(worker -> {
            out.println(workers.indexOf(worker) + "\t" + worker.getInfo());
        });
    }

    public static void addWorker(Firm firm) {
        Scanner sc = new Scanner(System.in);
        out.println("Add worker:");
        out.print("Enter name: ");
        String name = sc.next();
        out.print("Enter age: ");
        int age = sc.nextInt();
        out.print("Enter sex (0 - MALE/ 1 - FEMALE): ");
        Sex sex = Sex.values()[sc.nextInt()];
        out.print("Enter position (0 - DIRECTOR/ 1 - EMPLOYEE): ");
        Position position = Position.values()[sc.nextInt()];
        out.print("Enter salary: ");
        int salary = sc.nextInt();
        Worker worker = new Worker(new Human(name, age, sex), position, salary, 0);
        firm.AddWorker(worker);

        workerMenu(firm);
    }

    public static void removeWorker(Firm firm) {
        Scanner sc = new Scanner(System.in);
        out.println("Remove worker:");
        out.print("Enter id: ");
        int id = sc.nextInt();
        firm.DeleteWorkerById(id);

        workerMenu(firm);
    }

    public static void totalSalary(Firm firm) {
        final double[] total = {0};
        Scanner sc = new Scanner(System.in);
        firm.GetWorkers().forEach(worker -> {
            out.print("Enter " + worker.getName() + " work days: ");
            int days = sc.nextInt();
            double workerTotal = (double)worker.getSalary() * ((double) days /(double)30);
            total[0] += workerTotal;
            out.println(days + "\t" + worker.getSalary() + "\t" + workerTotal);
        });
        out.println("Total salary: " + total[0]);
    }
}
