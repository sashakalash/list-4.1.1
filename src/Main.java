import javax.management.RuntimeMBeanException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static ArrayList<String> tasks = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
       taskTracker();
    }

    public static void taskTracker() {
        while(true) {
            System.out.println("Выберите действие:\n1. Добавить задачу\n2. Вывести список задач\n3. Удалить задачу\n0. Выход");
            String input = scanner.nextLine();
            if("0".equals(input)) {
                break;
            }
            switch(input) {
                case "1":
                    addTask();
                    break;
                case "2":
                    showTasks();
                    break;
                case "3":
                    removeTask();
                    break;
                default:
                    System.out.println("Неверный номер операции! Повторите ввод");
                    break;
            }
        }
    }

    public static void addTask() {
        System.out.println("Введите задачу для планирования:");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Задача добавлена!");
    }

    public static void showTasks() {
        System.out.println("Ваш список задач:");
        for (int i =0; i < tasks.size(); i++) {
            String task = tasks.get(i);
            System.out.println((i + 1) + ". " + task);
        }
    }

    public static void removeTask() {
        while (true) {
            System.out.println("Введите номер задачи для удаления");
            String input = scanner.nextLine();
            try {
                int index = Integer.parseInt(input);
                tasks.remove(index - 1);
                System.out.println("Задача под номером " + index +  " удалена!");
                showTasks();
                break;
            }
            catch(RuntimeException err) {
                System.out.println("Введена неверная позиция задачи!");
            }
        }
    }
}
