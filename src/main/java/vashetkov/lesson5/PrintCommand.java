package vashetkov.lesson5;
import java.io.IOException;
import java.util.List;

public class PrintCommand {
    public static String printFileLine(String line) {
        StringBuilder message = new StringBuilder();
        String[] lineParts = line.split(" ");
        boolean isLineNumberSpecified = lineParts.length == 3;
        int lineNumber = isLineNumberSpecified == true ? tryParseToInteger(lineParts[1], message) : 0;
        String fileName = isLineNumberSpecified == true ? lineParts[2] : lineParts[1];
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

    public static int tryParseToInteger(String lineNumber, StringBuilder errorMessage){
        try {
            return Integer.parseInt(lineNumber);
        }catch(NumberFormatException e){
            errorMessage.append("Параметр \"номер строки\" не является числом!");
            return 0;
        }
    }
}
