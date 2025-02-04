# To-Do List Application

This project is a Java-based To-Do List application that simulates the functionality of Microsoft's To-Do list. It allows users to create, manage, and organize tasks in a structured manner. The application provides features such as adding tasks, viewing tasks, searching for tasks, sorting tasks, and managing task details like priority, due dates, and notes.

## Features

- **Task Management**: Create, edit, and delete tasks.
- **Task Details**: Each task includes a title, priority, due date, note, and creation date.
- **Task Steps**: Add multiple steps to a task for better task breakdown.
- **Task Sorting**: Sort tasks by title, priority, creation date, or due date.
- **Task Search**: Search for tasks by their title.
- **List Management**: Create and manage multiple to-do lists.
- **Persistence**: Save and load tasks to/from the file system.

## Project Structure

The project is structured into several classes, each responsible for a specific part of the application:

1. **Task Class**: Represents a single task with attributes like title, priority, due date, note, and creation date. It also includes a linked list of steps for detailed task breakdown.

2. **Node Class**: Represents a node in the linked list used to store steps for each task.

3. **LinkedList Class**: Implements a linked list data structure to manage the steps of a task.

4. **Main Class**: Contains the main logic of the application, including the user interface and file handling for saving and loading tasks.

## Code Overview

### Task Class

The `Task` class is the core of the application, representing a single task. It includes the following attributes:

- **Title**: The title of the task.
- **Priority**: The priority level of the task (integer value).
- **Due Date**: The due date of the task.
- **Note**: Additional notes or details about the task.
- **Created Date**: The date when the task was created.
- **Steps**: A linked list of steps associated with the task.

```java
public class Task<T> {
    private String title;
    private LinkedList<T> step;
    private int priority;
    private Date dueDate;
    private String note;
    private Date createdDate;
    private SimpleDateFormat simpleDateFormat;

    // Constructors, getters, setters, and toString method
}
```

### Node Class

The `Node` class represents a node in the linked list. It contains data and a reference to the next node.

```java
public class Node<T> {
    private T data;
    private Node<T> next;

    // Constructors, getters, setters, and equals method
}
```

### LinkedList Class

The `LinkedList` class implements a singly linked list. It provides methods to add, remove, and traverse elements in the list.

```java
public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private Node<T> help;
    private int size;

    // Methods to add, remove, search, and traverse the list
}
```

### Main Class

The `Main` class contains the main logic of the application, including the user interface and file handling. It allows users to:

- View existing to-do lists.
- Add new to-do lists.
- Add, edit, and delete tasks.
- Search for tasks.
- Sort tasks by title, priority, creation date, or due date.
- Save and load tasks to/from the file system.

```java
public class Main {
    public static void main(String[] args) throws ParseException {
        // Main logic and user interface
    }

    // Methods for task management, sorting, searching, and file handling
}
```

## How to Use

1. **Run the Application**: Compile and run the `Main` class to start the application.

2. **Main Menu**: The application will display a main menu with the following options:
   - **View Lists**: View existing to-do lists.
   - **Add a New List**: Create a new to-do list.
   - **Exit**: Exit the application and save all changes.

3. **Task Management**:
   - **View Tasks**: View all tasks in a selected list.
   - **Add a Task**: Add a new task to the list.
   - **Search for a Task**: Search for a task by its title.
   - **Sort Tasks**: Sort tasks by title, priority, creation date, or due date.
   - **Edit or Delete a Task**: Edit or delete an existing task.

4. **Persistence**: The application automatically saves all changes to the file system when exiting. Tasks are loaded from the file system when the application starts.

## File Handling

The application saves tasks and lists to the file system in a structured directory format. Each list is saved in a separate directory, and each task is saved as a text file within the corresponding list directory.

- **Directory Structure**:
  ```
  Data/
  ├── 1 (ListName)/
  │   ├── 1 (TaskTitle).txt
  │   ├── 2 (TaskTitle).txt
  │   └── ...
  ├── 2 (ListName)/
  │   ├── 1 (TaskTitle).txt
  │   └── ...
  └── ...
  ```

- **Task File Format**: Each task is saved in a text file with the following format:
  ```
  Title
  Step1 Step2 Step3 ...
  Priority
  Due Date
  Note
  Created Date
  ```

## Conclusion

This To-Do List application is a simple yet powerful tool for managing tasks and lists. It provides a user-friendly interface and robust features for task management, making it a useful tool for personal or professional use. The application is designed to be easily extendable, allowing for additional features and improvements in the future.

## License  

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.  

## Authors  

- Sayyed Hossein Hosseini DolatAbadi  
- Zohreh Soorani
