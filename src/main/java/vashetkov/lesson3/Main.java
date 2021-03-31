package vashetkov.lesson3;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Human> mainList = Do.task1(); //1. Заполнить ArrayList этими объектами.
        List<Human> dublicatesList = Do.task2(mainList); //2. Найти дубли в коллекции и вывести их в консоль.
        Do.task3(dublicatesList, mainList);//3. Удалить дубли из коллекции, должно остаться 7 объектов.
        Do.task4(mainList);//4. Отсортировать людей по ФИО
        Do.task5(mainList);//5. Отсортировать людей по возрасту
        Do.task6(mainList);//6. Отсортировать людей по адресу (лексикографическая сортировка полного адреса)
        Do.task9();//9. Написать программу сортирующую HashMap по ключу. (Создание и генерация данными какими захотите)
        Do.task10();//10. Написать программу сортирующую HashMap по значнию. (Создание и генерация данными какими захотите)
    }
}
