package vashetkov.lesson6;

import org.junit.Test;
import org.mockito.InjectMocks;
import vashetkov.lesson5.PrintCommand;
import vashetkov.lesson5.Reader;
import java.io.IOException;
import java.util.List;
import static org.junit.Assert.assertTrue;

public class PrintCommandTest {
    @InjectMocks
    PrintCommand printCommand;

    @InjectMocks
    Reader reader;

    @Test
    public void printFileLineWhenPrintThenPrintText() throws IOException {
        printCommand = new PrintCommand();
        reader = new Reader();
        printCommand.printFileLine("print 3 file.txt");
        List list = reader.fillList("file.txt");
        boolean result =  list.get(2).equals("four");
        assertTrue(result);
    }
}
