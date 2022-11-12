import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    }

    //========================================
    public static ArrayList<ArrayList<Task<String>>> GeneralList = new ArrayList<>();
    public static ArrayList<String> nameOfLists = new ArrayList<>();

    //========================================

    public static void veiwTask(ArrayList<Task<String>> arrayList, Scanner sc) throws ParseException {
        for (int i = 0; i < arrayList.size(); i++) {
            Print(i + "- " + arrayList.get(i).toString());
            arrayList.get(i).step.traverse();
            Print("======");
        }

        Print("Do you want to delete or edit a task?");
        Print("1.Yes   2.No");

        int choiceNumber = sc.nextInt();

        if (choiceNumber == 1) {
            Print("which one?");
            int indexOfTask = sc.nextInt();

            Print("1.Delete   2.Edit");
            choiceNumber = sc.nextInt();

            if (choiceNumber == 1) {
                arrayList.remove(indexOfTask);
                Print("The task was successfully deleted!");
            } else {
                editTask(arrayList.get(indexOfTask), sc);
            }
        }
        UserInterface();
    }

    public static void addNewTask(ArrayList<Task<String>> arrayList, Scanner sc) throws ParseException {

        Print("title: ");
        String title = sc.next();
        Print("priority: ");
        int priority = sc.nextInt();
        Print("Note: ");
        String note = sc.next();
        Print("Due Date: ");
        String dueDate = sc.next() + " " + sc.next() + " " + sc.next();

        Task<String> newTask = new Task<>(title, priority, dueDate, note);

        arrayList.add(newTask);

        Print("Do you want to add some steps for your task?");
        Print("1.Yes   2.No");
        int choiceNumber = sc.nextInt();

        int count = 1;
        while (choiceNumber == 1) {
            Print("Step " + count + ":");
            newTask.step.addLast(sc.next());
            Print("Done!");
            Print("Do you want to add more steps?");
            Print("1.Yes   2.No");
            choiceNumber = sc.nextInt();
            count++;
        }
        UserInterface();
    }

    public static void editTask(Task<String> task, Scanner sc) throws ParseException {

        Print("title: ");
        task.setTitle(sc.next());
        Print("priority: ");
        task.setPriority(sc.nextInt());
        Print("Note: ");
        task.setNote(sc.next());
        Print("Do you want to edit or delete steps of this task?");
        Print("1.Yes   2.No");
        int choiceNumber = sc.nextInt();
        if (choiceNumber == 1) {

        } else {
            UserInterface();
        }
    }

    //========================================
    public static void sortTaskByTitle(ArrayList<Task<String>> arrayList) {
        Task<String> task;
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = i + 1; j < arrayList.size(); j++) {
                if (arrayList.get(i).getTitle().charAt(0) > arrayList.get(j).getTitle().charAt(0)) {
                    task = arrayList.get(i);
                    arrayList.set(i, arrayList.get(j));
                    arrayList.set(j, task);
                }
            }
        }
    }

    public static void sortTaskByPriority(ArrayList<Task<String>> arrayList) {
        Task<String> task;
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = i + 1; j < arrayList.size() - 1; j++) {
                if (arrayList.get(i).getPriority() > arrayList.get(j).getPriority()) {
                    task = arrayList.get(i);
                    arrayList.set(i, arrayList.get(j));
                    arrayList.set(j, task);
                }
            }
        }
    }

    public static void sortTaskByCreatedDate(ArrayList<Task<String>> arrayList) {
        Task<String> task;
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = i + 1; j < arrayList.size() - 1; j++) {
                if (arrayList.get(i).getCreatedDate().after(arrayList.get(j).getCreatedDate())) {
                    task = arrayList.get(i);
                    arrayList.set(i, arrayList.get(j));
                    arrayList.set(j, task);
                }
            }
        }
    }


    public static void sortTaskByDueDate(ArrayList<Task<String>> arrayList) {
        Task<String> task;
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = i + 1; j < arrayList.size() - 1; j++) {
                if (arrayList.get(i).getDueDate().after(arrayList.get(j).getDueDate())) {
                    task = arrayList.get(i);
                    arrayList.set(i, arrayList.get(j));
                    arrayList.set(j, task);
                }
            }
        }
    }

    //========================================
    public static void addNewList(String name) {
        nameOfLists.add(name);
        GeneralList.add(new ArrayList<Task<String>>());
        Print("Your list created");
    }

    public static void Print(Object obj) {
        System.out.println(obj);
    }

}