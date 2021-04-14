package vashetkov.lesson7;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        /**
         * Task 1
         */
        //ClogMemory clogMemory = new ClogMemory();
        //clogMemory.clog();

        /**
         * Task 2
         */
        //ClogStack clogStack = new ClogStack();
        //clogStack.sillyMethod();

        /**
         * Task 3
         */
        CustomClassLoader classLoader = new CustomClassLoader();
        Class c = classLoader.loadClass("TestClass");
        Object obj = c.newInstance();
        System.out.println(obj);

    }
}
