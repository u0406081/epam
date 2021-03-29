package vashetkov.lesson1;


public class Main {

    public static void main(String[] args) {
        String firstString = "epam1SunOracle";
        String secondString = "epam2epam";
        new String("test").intern();
        int length = firstString.length();
        char[] charArray = firstString.toCharArray();
        byte[] byteArray = firstString.getBytes();
        String toUpperCase = firstString.toUpperCase();
        int firstIndexOf = firstString.indexOf("a");
        int lastIndexOf = firstString.lastIndexOf("a");
        boolean contains = firstString.contains("Sun");
        boolean endsWith = firstString.endsWith("Oracle");
        boolean startsWith = firstString.startsWith("Java");
        String replaceAll = firstString.replaceAll("a","o");
        String someText = new String("Я волком бы\n" +
                "выгрыз\n" +
                "бюрократизм.\n" +
                "К мандатам\n" +
                "почтения нету.\n" +
                "К любым\n" +
                "чертям с матерями\n" +
                "катись\n" +
                "любая бумажка.\n" +
                "Но эту…\n" +
                "Я\n" +
                "достаю\n" +
                "из широких штанин\n" +
                "дубликатом\n" +
                "бесценного груза.\n" +
                "Читайте,\n" +
                "завидуйте,\n" +
                "я —\n" +
                "гражданин\n" +
                "Советского Союза.");
        String substring = someText.substring(44, 90);
        String[] split = someText.split(" ");


        String reverse = "";
        for (int i = charArray.length - 1; i >= 0; i--) {
            reverse = reverse + charArray[i];
        }


        System.out.println("1. Получить длину строки: " + length);
        System.out.println("2. Сравнить 2 строки без учета регистра: " + firstString.equalsIgnoreCase(secondString));
        System.out.println("3. Создать новую строку с помощью конструктора и занести ее в пул литералов: Надо вызвать метод intern()");
        System.out.println("4. Получить из строки массив символов: " + charArray);
        System.out.println("5. Получить из строки массив байтов: " + byteArray);
        System.out.println("6. Привести строку к верхнему регистру: " + toUpperCase);
        System.out.println("7. Найти первую позицию символа \"а\" в строке: " + firstIndexOf);
        System.out.println("8. Найти последнюю позицию символа \"а\" в строке: " + lastIndexOf);
        System.out.println("9. Проверить содержит-ли строка слово \"Sun\": " + contains);
        System.out.println("10. Проверить оканчивается-ли строка на \"Oracle\": " + endsWith);
        System.out.println("11. Проверить начинается-ли строка на \"Java\": " + startsWith);
        System.out.println("12. Заменить все символы \"а\" в строке на символ \"о\": " + replaceAll);
        System.out.println("13. Получить подстроку с 44 символа по 90 символ: " + substring);
        System.out.println("14. Разбить строку по символу пробел (т.е. чтобы каждое слово было отдельным элементом массива): " + split);
        System.out.println("15. Поменять последовательность символов в строке на обратную: " + reverse);
    }
}
