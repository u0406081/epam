package vashetkov.lesson7;

public class Main {
    /**
     * Task 3
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        CustomClassLoader classLoader = new CustomClassLoader();
        Class c = classLoader.loadClass("TestClass");
        Object obj = c.newInstance();
        System.out.println(obj);
    }
}
