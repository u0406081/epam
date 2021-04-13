package vashetkov.lesson6;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import vashetkov.lesson5.DeleteCommand;
import vashetkov.lesson5.Reader;
import java.io.IOException;
import java.util.List;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class DeleteCommandTest {
    @InjectMocks
    DeleteCommand deleteCommand;

    @InjectMocks
    Reader reader;

    @Test
    public void deleteLineInFileWhenDeleteThenTextInFileDelete() throws IOException {
        deleteCommand = new DeleteCommand();
        reader = new Reader();
        deleteCommand.deleteLineInFile("delete 3 file.txt");
        List list = reader.fillList("file.txt");
        System.out.println(list);
        boolean result =  !list.get(2).equals("three");
        assertTrue(result);
    }
}
