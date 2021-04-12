package vashetkov.lesson5;
public class FilterCommand {

    public String filter(String line){
        String command = line.substring(0,line.indexOf(" "));
        String message = null;
        AddCommand addCommand = new AddCommand();
        DeleteCommand deleteCommand = new DeleteCommand();
        PrintCommand printCommand = new PrintCommand();

        if ("add".equals(command))
            message = addCommand.addLineInFile(line);
        else if ("delete".equals(command))
            message = deleteCommand.deleteLineInFile(line);
        else if ("print".equals(command))
            message = printCommand.printFileLine(line);
        return message;
    }
}
