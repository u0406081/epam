package vashetkov.lesson2.MyExceptions;

public class ElementIsNullUncheckedException extends RuntimeException{
    public ElementIsNullUncheckedException(String message) {
        super(message);
    }
}
