import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    static ArrayList<Task> stringStore = new ArrayList<>();
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
            Scanner sc = new Scanner(System.in);
            printLine();
            System.out.println("Hello! I'm Duke");
            System.out.println("What can I do for you?");
            printLine();

            if (sc.hasNext()) {
                String input = sc.nextLine();
                while (!input.equals("bye")) {
                    try{
                    if (input.equals("list")) {
                        printLine();
                        System.out.println(" Here are the tasks in your list:");
                        int sizeStore = stringStore.size();
                        for (int i = 1; i < sizeStore + 1; i++) {
                            System.out.println(i + "." + stringStore.get(i - 1));
                        }
                        printLine();
                    } else if (input.split(" ")[0].equals("done")) {
                        int doneTask = Integer.parseInt(input.split(" ")[1]) - 1;
                        if(doneTask + 1 > stringStore.size() || doneTask < 0){
                            throw new DukeInvalidDoneNumException(input);
                        }
                        stringStore.get(doneTask).markAsDone();
                    } else if (input.split(" ")[0].equals("todo")) {
                        if (input.split(" ").length == 1) {
                            throw new DukeEmptyToDoException(input);
                        }
                        String tasker = stringBuilder(input.split(" "), 1, input.split(" ").length - 1);
                        Todo todoTask = new Todo(tasker);
                        stringStore.add(todoTask);
                        printer(todoTask);
                    } else if (input.split(" ")[0].equals("deadline")) {
                        if (input.split(" ").length == 1) {
                            throw new DukeEmptyDeadlineException(input);
                        }
                        String deadliner = stringBuilder(input.split(" "), 1, input.split(" ").length - 1);
                        String[] deadlinerparts = deadliner.split("/by");
                        if(deadlinerparts.length == 1){
                            throw new DukeEmptyDeadlineTImeException(input);
                        }
                        Deadline deadlineTask = new Deadline(deadlinerparts[0], deadlinerparts[1]);
                        stringStore.add(deadlineTask);
                        printer(deadlineTask);
                    } else if (input.split(" ")[0].equals("event")) {
                        if (input.split(" ").length == 1) {
                            throw new DukeEmptyEventException(input);
                        }
                        String eventer = stringBuilder(input.split(" "), 1, input.split(" ").length - 1);
                        String[] eventParts = eventer.split("/at");
                        if(eventParts.length == 1){
                            throw new DukeEmptyEventTimeException(input);
                        }
                        Event eventTask = new Event(eventParts[0], eventParts[1]);
                        stringStore.add(eventTask);
                        printer(eventTask);
                    } else {
                        throw new DukeUnknownInputException(input);
                    }
                    }  catch (DukeUnknownInputException e){
                        printLine();
                        System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
                        printLine();
                    } catch (DukeEmptyToDoException e) {
                        printLine();
                        System.out.println("OOPS!!! The description of a todo cannot be empty.");
                        printLine();
                    } catch (DukeEmptyEventException e) {
                        printLine();
                        System.out.println("OOPS!!! The description of a event cannot be empty.");
                        printLine();
                    } catch (DukeEmptyDeadlineException e) {
                        printLine();
                        System.out.println("OOPS!!! The description of a deadline cannot be empty.");
                        printLine();
                    } catch (DukeInvalidDoneNumException e) {
                        printLine();
                        System.out.println("OOPS!!! The invalid done number.");
                        printLine();
                    } catch (DukeEmptyDeadlineTImeException e) {
                        printLine();
                        System.out.println("OOPS!!! The description of a deadline time cannot be empty.");
                        printLine();
                    } catch (DukeEmptyEventTimeException e) {
                        printLine();
                        System.out.println("OOPS!!! The description of a event time cannot be empty.");
                        printLine();
                    }
                    if (sc.hasNext()) {
                        input = sc.nextLine();
                    }
                }
                printLine();
                System.out.println("Bye. Hope to see you again soon!");
                printLine();

            }

    }

    public static String stringBuilder(String[] arr, int start, int end){
        String store = "";
        for (int i = start; i <= end; i++) {
            if(i == end){
                store += arr[i];
            } else {
                store += arr[i] + " ";
            }

        }
        return store;
    }

    public static void printer(Task task){
        printLine();
        System.out.println("Got it. I've added this task:");
        System.out.println(task);
        System.out.println("Now you have " + String.valueOf(stringStore.size()) + " tasks in the list.");
        printLine();

    }
    public static void printLine(){
        System.out.println(" ____________________________________________________________");
    }



}
