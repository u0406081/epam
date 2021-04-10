import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
        FilterCommand filterCommand = new FilterCommand();
            while (scanner.hasNextLine()){
                String line = scanner.nextLine().toLowerCase();
                if (line.equals("quit")) break;
                System.out.println(filterCommand.filter(line));
            }
        }
    }
}
