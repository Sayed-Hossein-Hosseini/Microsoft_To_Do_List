import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main { 
    public static void main(String[] args) throws ParseException{
        Print("To Do List");

        if (readName() != null)
            for (String place : readName()) {

                nameOfLists.add (place) ;
            }

        GeneralList = read() ;

        UserInterface();
    }

    public static void UserInterface() throws ParseException {

        Scanner sc = new Scanner(System.in);

        Print("---------------");
        Print("1.Veiw lists   2.Add a new list   3.Exit");
        Print("Please enter your choice:");

        int choiceNumber = sc.nextInt();
        switch (choiceNumber) {
            //veiw Lists
            case 1: {
                if (nameOfLists.isEmpty()) {
                    Print("You don't have any lists yet!");
                    UserInterface();
                    break;
                } else {
                    for (int i = 0; i < nameOfLists.size(); i++) {
                        Print(i + ". " + nameOfLists.get(i));
                    }
                    Print("Please enter the list number you want:");
                    int desiredIndex = sc.nextInt();

                    Print(nameOfLists.get(desiredIndex) + ": ");

                    Print("1.Veiw the tasks of list");
                    Print("2.Search in tasks");
                    Print("3.Add a task");
                    Print("4.Sort");
                    choiceNumber = sc.nextInt();

                    switch (choiceNumber) {
                        //veiw the tasks of list
                        case 1: {
                            if (GeneralList.get(desiredIndex).isEmpty()) {
                                Print("You don't have any task in this list!");
                                Print("Do you want to add a new task?");
                                Print("1.Yes   2.No");
                                choiceNumber = sc.nextInt();
                                if (choiceNumber == 1) {
                                    addNewTask(GeneralList.get(desiredIndex), sc);
                                    UserInterface();
                                    break;
                                } else {
                                    UserInterface();
                                    break;
                                }
                            } else {
                                veiwTask(GeneralList.get(desiredIndex), sc);
                            }
                        }
                        break;
                        //search in task
                        case 2: {
                            if (GeneralList.get(desiredIndex).isEmpty()) {
                                Print("You don't have any task in this list!");
                                UserInterface();
                                break;
                            } else {
                                Print("Please enter the title of task:");
                                String title = sc.next();
                                for (int i = 0; i < GeneralList.get(desiredIndex).size(); i++) {
                                    if (GeneralList.get(desiredIndex).get(i).getTitle().equals(title)) {
                                        Print(GeneralList.get(desiredIndex).get(i).toString());

                                        Print("Do you want to delete or edit this task?");
                                        Print("1.Yes   2.No");

                                        choiceNumber = sc.nextInt();

                                        if (choiceNumber == 1) {
                                            Print("1.Delete   2.Edit");
                                            choiceNumber = sc.nextInt();

                                            if (choiceNumber == 1) {
                                                GeneralList.get(desiredIndex).remove(i);
                                                Print("The task was successfully deleted!");
                                            } else {
                                                editTask(GeneralList.get(desiredIndex).get(i), sc);
                                            }
                                        }
                                        UserInterface();
                                        break;
                                    } else {
                                        Print("No task was found with this name!!");
                                    }
                                }
                            }
                        }
                        break;
                        //Add a task
                        case 3: {
                            addNewTask(GeneralList.get(desiredIndex), sc);
                            UserInterface();
                        }
                        break;
                        //sort
                        case 4: {
                            if (GeneralList.get(desiredIndex).isEmpty()) {
                                Print("You don't have any task in this list!");
                                UserInterface();
                                break;

                            } else {

                                Print("Sort by:");
                                Print("1.Title");
                                Print("2.Priority");
                                Print("3.CreatedDate");
                                Print("4.DueDate");

                                choiceNumber = sc.nextInt();
                                switch (choiceNumber) {
                                    case 1: {
                                        sortTaskByTitle(GeneralList.get(desiredIndex));
                                        veiwTask(GeneralList.get(desiredIndex), sc);
                                    }
                                    break;
                                    case 2: {
                                        sortTaskByPriority(GeneralList.get(desiredIndex));
                                        veiwTask(GeneralList.get(desiredIndex), sc);
                                    }
                                    break;
                                    case 3: {
                                        sortTaskByCreatedDate(GeneralList.get(desiredIndex));
                                        veiwTask(GeneralList.get(desiredIndex), sc);
                                    }
                                    break;
                                    case 4: {
                                        sortTaskByDueDate(GeneralList.get(desiredIndex));
                                        veiwTask(GeneralList.get(desiredIndex), sc);
                                    }
                                    break;
                                    default:
                                }
                            }
                        }
                        break;
                        default: {
                            Print("Invalid input!");
                            Print("Please try again:");
                            UserInterface();
                            break;
                        }
                    }

                }
            }
            break;
            //Add a new list
            case 2: {
                Print("Please enter the name of list: ");
                addNewList(sc.next());
                UserInterface();
            }
            break;
            //Exit
            case 3: {

                Print("Good luck => ");
                write(GeneralList , nameOfLists);
                System.exit(0);
            }
            break;
            default: {
                Print("Invalid input!");
                Print("Please try again:");
                UserInterface();
            }
            break;
        }
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

    public static void write(ArrayList<ArrayList<Task<String>>> toDo, ArrayList<String> name) {

        try {

            if (!toDo.isEmpty()) {

                File dataM = new File("C:\\Users\\shoss\\Documents\\Idea\\project-1-todo-list-shiftdelete\\Data");

                dataM.mkdir(); // make directory data

                for (int i = 0; i < name.size(); i++) {

                    File group1 = new File("C:\\Users\\shoss\\Documents\\Idea\\project-1-todo-list-shiftdelete\\Data\\" + (i + 1) + " (" + name.get(i) + ")");

                    group1.mkdir(); // make directory

                    for (int j = 0; j < toDo.get(i).size(); j++) {

                        FileWriter group2 = new FileWriter("C:\\Users\\shoss\\Documents\\Idea\\project-1-todo-list-shiftdelete\\Data\\" + (i + 1) + " (" + name.get(i) + ")" + "\\" + "1 (" + toDo.get(i).get(j).getTitle() + ")" + ".txt"); // make Notepad

                        BufferedWriter data = new BufferedWriter(group2);

                        data.write(toDo.get(i).get(j).getTitle() + "\n"); // write the Title

                        if (toDo.get(i).get(j).getStep() != null) {

                            Node<String> test = toDo.get(i).get(j).getStep().getHead();

                            while (test != null) {

                                data.write(test.getData() + " "); // write the Steps

                                test = test.getNext();
                            }
                        }

                        data.write("\n" + toDo.get(i).get(j).getPriority() + "\n"); // write the Priority

                        data.write(toDo.get(i).get(j).getDueDate() + "\n"); // write Due Date

                        data.write(toDo.get(i).get(j).getNote() + "\n"); // write the Note

                        data.write(toDo.get(i).get(j).getCreatedDate() + ""); // write the Created Date

                        data.close();
                    }
                }
            }
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    public static String[] readName() {  // read name task list

        File file = new File("C:\\Users\\shoss\\Documents\\Idea\\ToDoList\\Data");

        if (file.list() == null) {return null;}

        String[] name = file.list();

        for (int i = 0; i < name.length; i++) {

            name[i] = name[i].substring(3, name[i].length() - 1);
        }

        return name;
    }

    public static ArrayList<ArrayList<Task<String>>> read() { // read File

        ArrayList<ArrayList<Task<String>>> list = new ArrayList<>();

        try {

            File file = new File("C:\\Users\\shoss\\Documents\\Idea\\project-1-todo-list-shiftdelete\\Data");

            File[] path1 = file.listFiles();

            String [] time ;

            for (int i = 0; i < path1.length; i++) {

                File[] path2 = path1[i].listFiles();

                for (int j = 0; j < path2.length; j++) {

                    Task <String> task = new Task();

                    FileReader test = new FileReader(path2[j].getPath());

                    SimpleDateFormat data = new SimpleDateFormat("E MMM dd HH:mm:ss zz yyyy");

                    BufferedReader reader = new BufferedReader(test);

                    task.setTitle(reader.readLine()); // read Title

                    String link = reader.readLine(); // read Steps

                    if (link != null) {

                        LinkedList<String> step1 = new LinkedList<>();

                        String[] step2 = link.split(" ");

                        for (int k = 0; k < step2.length; k++) {

                            step1.addLast(step2[k]);
                        }

                        task.setStep(step1);
                    }

                    task.setPriority(Integer.parseInt(reader.readLine())); // read Priority

                    time = reader.readLine().split(" ") ;

                    task.setDueDate(data.parse(time[0] + " " + time[1] + " " + time[2] + " " + time[3] + " " + time[4] + " " + time[5])); // read Due Date

                    task.setNote(reader.readLine()); // read Note

                    time = reader.readLine().split(" ") ;

                    task.setCreatedDate(data.parse(time[0] + " " + time[1] + " " + time[2] + " " + time[3] + " " + time[4] + " " + time[5])); // read Created Date

                    reader.close();

                    path2[j].delete(); // delete file
                }

                path1[i].delete(); // delete directory
            }

            file.delete(); // delete directory data

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return list;
    }

}
