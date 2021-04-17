package vashetkov.lesson5;
import java.io.IOException;
import java.util.List;

public class AddCommand {
    StringBuilder message = new StringBuilder();
    boolean isLineNumberSpecified;
    int lineNumber;
    String fileName;
    String text;


    public String addLineInFile(String line){
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

    public void parceLine(String line){
        String[] lineParts = line.split(" ");
        this.isLineNumberSpecified = lineParts.length == 4;
        this.lineNumber = isLineNumberSpecified == true ? tryParseToInteger(lineParts[1]) : 0;
        this.fileName = isLineNumberSpecified == true ? lineParts[2] : lineParts[1];
        this.text = isLineNumberSpecified == true ? lineParts[3] : lineParts[2];
    }

    public int tryParseToInteger(String lineNumber){
        try {
            return Integer.parseInt(lineNumber);
        }catch(NumberFormatException e){
            message.append("Параметр \"номер строки\" не является числом!");
            return 0;
        }
    }


}
