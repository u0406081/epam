package vashetkov.lesson3;

import vashetkov.lesson3.Comparators.ComparatorAddress;
import vashetkov.lesson3.Comparators.ComparatorAge;
import vashetkov.lesson3.Comparators.ComparatorFIO;
import java.util.*;

/**
 * @author  Vashetkov
 */
public class AllMethods {

    /**
     * Returns Human object
     * @param fio
     * @param age
     * @param address
     * @return object Human
     */
    Human getHuman(String fio, Integer age, Address address){
        Human human = new Human();
        human.setFio(fio);
        human.setAge(age);
        human.setAddress(address);
        return human;
    }

    /**
     * Returns list of Human objects
     * @return List Human objects
     */
    ArrayList<Human> getHumanList(){
        ArrayList<Human> list = new ArrayList<Human>(10);
        Address address1 = new Address("Москва", "Мойка", "12", null);
        Address address2 = new Address("Москва", "Льва Толстого", "1", null);
        Address address3 = new Address("Москва", "Гоголя", "1", null);
        Address address4 = new Address("Москва", "Маяковского", "1", null);
        Address address5 = new Address("Москва", "Фета", "1", null);
        Address address6 = new Address("Москва", "Рождественского", "1", null);
        Address address7 = new Address("Москва", "Евтушеннко", "1", null);

        list.add(getHuman("Пушкин Александр Сергеевич",37, address1));
        list.add(getHuman("Пушкин Александр Сергеевич",37, address1));
        list.add(getHuman("Толстой Лев Николаевич",82, address2));
        list.add(getHuman("Толстой Лев Николаевич",82, address2));
        list.add(getHuman("Гоголь Николай Васильевич",42, address3));
        list.add(getHuman("Гоголь Николай Васильевич",42, address3));
        list.add(getHuman("Маяковский Владимир Владимирович",36, address4));
        list.add(getHuman("Фет Афанасий Афанасьевич",71, address5));
        list.add(getHuman("Рождественский Роберт Иванович",62, address6));
        list.add(getHuman("Евтушеннко Евгенний Алексарндрович",84, address7));
        return list;
    }

    /**
     * Returns list of dublicates
     * @param mainList list that contains duplicated objects
     * @return List Human objects
     */
    public List<Human> getDuplicates(List<Human> mainList) {
        List<Human> dublicates = new ArrayList<Human>();
        HashMap<String, Human> map = new HashMap<String, Human>();
        for (Human human : mainList){
            Human h = map.get(human.getFio());
            if (h != null)
                dublicates.add(h);
            else
                map.put(human.getFio(), human);
        }
        return dublicates;
    }

    /**
     * Заполнить ArrayList этими объектами.
     * @return List of Human objects
     */
    public ArrayList<Human> task1(){
        return getHumanList();
    }

    /**
     * Найти дубли в коллекции и вывести их в консоль.
     * @param mainList list that contains duplicated objects
     * @return List of Human objects
     */
    public List<Human> task2(ArrayList<Human> mainList){
        return getDuplicates(mainList);
    }

    /**
     * Удалить дубли из коллекции, должно остаться 7 объектов.
     * @param dublicatesList
     * @param mainList
     */
    public void task3(List<Human> dublicatesList, ArrayList<Human> mainList){
        for (Human d : dublicatesList){
            System.out.println("dublicate: " + d.getFio());
            mainList.remove(d);
        }
        for (Human h : mainList){
            System.out.println(h.getFio());
        }
    }

    /**
     * Отсортировать людей по ФИО
     * @param mainList
     */
    public void task4(ArrayList<Human> mainList){
        Collections.sort(mainList, new ComparatorFIO());
    }

    /**
     * Отсортировать людей по возрасту
     * @param mainList
     */
    public void task5(ArrayList<Human> mainList) {
        Collections.sort(mainList, new ComparatorAge());
    }

    /**
     * Отсортировать людей по адресу (лексикографическая сортировка полного адреса)
     * @param mainList
     */
    public void task6(ArrayList<Human> mainList) {
        Collections.sort(mainList, new ComparatorAddress());
    }

    /**
     * Create random values Map
     * @return HashMap object
     */
    public Map<String,Integer> createMap(){
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("3",3);
        map.put("1",1);
        map.put("4",4);
        map.put("8",8);
        map.put("6",6);
        return map;
    }

    /**
     * Написать программу сортирующую HashMap по ключу. (Создание и генерация данными какими захотите)
     */
    public void task9() {
        Map<String,Integer> map = createMap();
        List sortKeys = new ArrayList(map.keySet()); //возможно не это было нужно
        System.out.println("sorted Map by keys: " + sortKeys);
    }

    /**
     * Написать программу сортирующую HashMap по значнию. (Создание и генерация данными какими захотите)
     */
    public void task10() {
        Map<String,Integer> map = createMap();
        List sortValues = new ArrayList(map.values()); //возможно не это было нужно
        System.out.println("sorted Map by values: " + sortValues);
    }
}
