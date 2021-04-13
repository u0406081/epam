package vashetkov.lesson6;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import vashetkov.lesson5.AddCommand;
import vashetkov.lesson5.Reader;
import java.io.IOException;
import java.util.List;
import static org.junit.Assert.assertTrue;


@RunWith(MockitoJUnitRunner.class)
public class AddCommandTest {
    @InjectMocks
    AddCommand addCommand;

    @InjectMocks
    Reader reader;

    @Test
    public void addLineInFileWhenAddThenTextInFile() throws IOException {
        addCommand = new AddCommand();
        reader = new Reader();
        addCommand.addLineInFile("add 3 file.txt three");
        addCommand.addLineInFile("add 4 file.txt four");
        List list = reader.fillList("file.txt");
        boolean result =  list.get(2).equals("three");
        assertTrue(result);
    }
}
