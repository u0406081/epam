package vashetkov.lesson5;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Reader {
    public static List fillList(String fileName) throws IOException {
        List<String> list = new LinkedList<String>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/resources/" + fileName)))) {
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null) {
                list.add(index, line);
                index++;
            }
            return list;
        }
    }
}
