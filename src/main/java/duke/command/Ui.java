package duke.command;

import duke.task.Task;

import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * A class which deals with the interactions of the user, including printing and requesting for input.
 */
public class Ui {
    /**
     * Returns the welcome message.
     *
     * @return Returns the welcome message.
     */
    public static String printWelcome() {
        return "Hello! I'm Duke\nWhat can I do for you?";
    }

    /**
     * Returns the error message due to file not found.
     *
     * @return Returns the error message due to file not found.
     */
    public String showLoadingError() {
        return "Error: Unable to load. File not found. Empty list is created.";
    }

    /**
     * Returns a string response containing the string representation of the list of tasks.
     *
     * @param list The list to be printed.
     * @return Returns a string response containing the string representation of the list of tasks.
     */
    public String printList(ArrayList<Task> list) {
        if (list.isEmpty()) {
            return "No task found";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Here are the tasks in your list:\n");
            IntStream.rangeClosed(1, list.size()).forEach(x -> {
                Task task = list.get(x - 1);
                sb.append(x).append(". ").append(task.toString()).append("\n");
            });
            return sb.toString();
        }
    }

    /**
     * Returns a message to remind user that a task has been marked as done.
     *
     * @param task The task to be marked as done.
     * @return Returns a message to remind user that a task has been marked as done.
     */
    String printMarkDone(Task task) {
        return ("Nice! I've marked this task as done:\n  " + task.toString());
    }

    /**
     * Returns a message to remind user that a task has been removed from the list.
     *
     * @param removed The deleted task.
     * @param list The list, in which the task has been removed from.
     * @return Returns a message to remind user that a task has been removed from the list.
     */
    String printDeleteTask(Task removed, ArrayList<Task> list) {
        return ("Noted. I've removed this task:\n" +
                "  " + removed.toString() + "\n" +
                "Now you have " + list.size() + " in the list.");
    }

    /**
     * Returns a message to remind user that a task has been added to the list.
     *
     * @param task The task to be added.
     * @param list The list, to which the task is to be added to.
     * @return Returns a message to remind user that a task has been added to the list.
     */
    String printAddTask(Task task, ArrayList<Task> list) {
        return ("Got it. I've added this task:\n" +
                "  " + task.toString() + "\n" +
                "Now you have " + list.size() + " tasks in the list");
    }
}
