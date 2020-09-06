public class HelpCommand extends Command {
    private String command;

    HelpCommand(String command) {
        this.command = command;
    }

    @Override
    public String execute(TaskList tasklist, UI ui) throws DukeException {
        String message = "Welcome to the help list!!! Below are the list of commands that you can enter: \n";
        message += "1) To add a todo say \'todo <task description>\'\n";
        message += "2) To add a deadline say \' deadline <task description> /by <dd-MM-yyyy HH:mm> \'\n";
        message += "3) To add an event say \' event <task description> /at <dd-MM-yyyy HH:mm> \'\n";
        message += "4) To view your tasks list enter \'list\'\n";
        message += "5) To find your tasks by keywords enter \'find <keyword>\'\n";
        message += "6) To find your tasks by tags enter \'findtag <tag>\'\n";
        message += "7) To mark a task as done enter \'done <task number>\'\n";
        message += "8) To tag a task enter \'tag <task number> <tag>\'\n";
        return message;
    }
}
