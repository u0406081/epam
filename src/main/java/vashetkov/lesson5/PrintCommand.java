import java.io.IOException;
import java.util.List;

public class PrintCommand {
    StringBuilder message = new StringBuilder();
    boolean isLineNumberSpecified;
    int lineNumber;
    String fileName;
    String text;

    public String printFileLine(String line) {
        message.setLength(0);
        parceLine(line);
        if (message.length() > 0) return message.toString();

        List<String> list = null;
        try {
            list = Reader.fillList(fileName);
        } catch (IOException e) {
            message.append("Не удалось открыть файл: " + fileName +", попробуйте \"file.txt\"");
        }
        if (message.length() > 0) return message.toString();

        if (isLineNumberSpecified) message.append(list.get(lineNumber-1));
        else {
            for (String s : list) {
                message.append(s+"\n");
            }
        }
        return message.toString();
    }

    public void parceLine(String line){
        String[] lineParts = line.split(" ");
        this.isLineNumberSpecified = lineParts.length == 3;
        this.lineNumber = isLineNumberSpecified == true ? tryParseToInteger(lineParts[1], message) : 0;
        this.fileName = isLineNumberSpecified == true ? lineParts[2] : lineParts[1];
    }

    public int tryParseToInteger(String lineNumber, StringBuilder errorMessage){
        try {
            return Integer.parseInt(lineNumber);
        }catch(NumberFormatException e){
            errorMessage.append("Параметр \"номер строки\" не является числом!");
            return 0;
        }
    }
}
