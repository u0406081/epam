package vashetkov.lesson7;

import java.util.LinkedList;
import java.util.List;

public class ClogMemory {
    static final List<Object[]> arrays = new LinkedList<>();
    public void clog() {
        for (; ; ) {
            arrays.add(new Object[10000]);
        }
    }
}
