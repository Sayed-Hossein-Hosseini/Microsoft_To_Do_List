import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

    }

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

}