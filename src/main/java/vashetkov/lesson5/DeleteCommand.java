package vashetkov.lesson5;
import java.io.IOException;
import java.util.List;

public class DeleteCommand {
    StringBuilder message = new StringBuilder();
    Reader reader = new Reader();
    boolean isLineNumberSpecified;
    int lineNumber;
    String fileName;
    String text;

    public String deleteLineInFile(String line) {
        message.setLength(0);
        parceLine(line);
        if (message.length() > 0) return message.toString();

        List<String> list = null;
        try {
            list = reader.fillList(fileName);
        } catch (IOException e) {
            message.append("Не удалось открыть файл: " + fileName +", попробуйте \"file.txt\"");
        }
        if (message.length() > 0) return message.toString();


        if (isLineNumberSpecified == true)list.remove(lineNumber-1);
        else list.remove(list.size()-1);

        try {
            Writer.writeList(fileName, list);
        } catch (IOException e) {
            e.printStackTrace();
        }
        message.append("Строка успешно удалена!");
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
