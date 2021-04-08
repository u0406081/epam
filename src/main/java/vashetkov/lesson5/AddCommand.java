package vashetkov.lesson5;
import java.io.*;
import java.util.List;

public class AddCommand {

    public static String addLineInFile(String line){
        StringBuilder message = new StringBuilder();
        String[] lineParts = line.split(" ");
        boolean isLineNumberSpecified = lineParts.length == 4;
        int lineNumber = isLineNumberSpecified == true ? tryParseToInteger(lineParts[1], message) : 0;
        String fileName = isLineNumberSpecified == true ? lineParts[2] : lineParts[1];
        String text = isLineNumberSpecified == true ? lineParts[3] : lineParts[2];
        if (message.length() > 0) return message.toString();

        List<String> list = null;
        try {
            list = Reader.fillList(fileName);
        } catch (IOException e) {
            message.append("Не удалось открыть файл: " + fileName +", попробуйте \"file.txt\"");
        }
        if (message.length() > 0) return message.toString();



        if (isLineNumberSpecified && list.size() < lineNumber) {
            for (int i = list.size(); i < lineNumber + 1; i++) {
                if (i == lineNumber) list.set(i-1, text);
                else list.add(i, "");
            }
        }else if (isLineNumberSpecified && list.size() > lineNumber || list.size() == lineNumber){
            list.add(lineNumber-1, text);
        }else if (!isLineNumberSpecified){
            list.add(text);
        }


        try {
            Writer.writeList(fileName, list);
        } catch (IOException e) {
            e.printStackTrace();
        }
        message.append("Строка успешно добавлена!");
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
