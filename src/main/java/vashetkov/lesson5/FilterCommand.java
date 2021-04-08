package vashetkov.lesson5;

public class FilterCommand {
    public String filter(String line){
        String command = line.substring(0,line.indexOf(" "));
        String message = null;
        if ("add".equals(command))
            message = AddCommand.addLineInFile(line);
        else if ("delete".equals(command))
            message = DeleteCommand.deleteLineInFile(line);
        else if ("print".equals(command))
            message = PrintCommand.printFileLine(line);
        return message;
    }
}
