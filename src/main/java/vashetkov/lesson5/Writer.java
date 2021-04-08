package vashetkov.lesson5;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Writer {
    public static void writeList(String fileName, List<String> list) throws IOException {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/resources/"+fileName))){
            for (int i = 0; i < list.size(); i++) {
                bw.write(list.get(i) + "\n");
            }
            bw.flush();
        }
    }
}

