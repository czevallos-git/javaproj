import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class TaskManager {
    private List<Task> tasks;
    private final String filePath = "data/tasks.txt";

    public TaskManager() {
        tasks = new ArrayList<>();
        loadTasksFromFile();
    }

    public void addTask(String description) {
        tasks.add(new Task(description));
        saveTasksToFile();
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to show.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public void markTaskAsComplete(int taskNumber) {
        // check task number in range
        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            tasks.get(taskNumber - 1).markAsComplete();
            saveTasksToFile();
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public void removeTask(int taskNumber) {
        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            tasks.remove(taskNumber - 1);
            saveTasksToFile();
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private void loadTasksFromFile(){
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";", 2);
                Task task = new Task(parts[1]);
                if (parts[0].equals("1")) {
                    task.markAsComplete();
                }
                tasks.add(task);
            }

        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
    }

    private void saveTasksToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Task task : tasks) {
                writer.write((task.isCompleted() ? "1" : "0") + ";" + task.getDescription());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }
}