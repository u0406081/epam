package vashetkov.lesson3;

import vashetkov.lesson3.Comparators.ComparatorAddress;
import vashetkov.lesson3.Comparators.ComparatorAge;
import vashetkov.lesson3.Comparators.ComparatorFIO;

import java.util.*;

public class Do {
    static ArrayList<Human> getHumanList(){
        Address address1 = new Address("Москва", "Мойка", "12", null);
        Human human1 = new Human();
        human1.setFio("Пушкин Александр Сергеевич");
        human1.setAge(37);
        human1.setAddress(address1);

        Human human2 = new Human();
        human2.setFio("Пушкин Александр Сергеевич");
        human2.setAge(37);
        human2.setAddress(address1);

        Address address2 = new Address("Москва", "Льва Толстого", "1", null);
        Human human3 = new Human();
        human3.setFio("Толстой Лев Николаевич");
        human3.setAge(82);
        human3.setAddress(address2);

        Human human4 = new Human();
        human4.setFio("Толстой Лев Николаевич");
        human4.setAge(82);
        human4.setAddress(address2);

        Address address3 = new Address("Москва", "Гоголя", "1", null);
        Human human5 = new Human();
        human5.setFio("Гоголь Николай Васильевич");
        human5.setAge(42);
        human5.setAddress(address3);

        Human human6 = new Human();
        human6.setFio("Гоголь Николай Васильевич");
        human6.setAge(42);
        human6.setAddress(address3);

        Address address4 = new Address("Москва", "Маяковского", "1", null);
        Human human7 = new Human();
        human7.setFio("Маяковский Владимир Владимирович");
        human7.setAge(36);
        human7.setAddress(address3);

        Address address5 = new Address("Москва", "Фета", "1", null);
        Human human8 = new Human();
        human8.setFio("Фет Афанасий Афанасьевич");
        human8.setAge(36);
        human8.setAddress(address5);

        Address address6 = new Address("Москва", "Рождественского", "1", null);
        Human human9 = new Human();
        human9.setFio("Рождественский Роберт Иванович");
        human9.setAge(62);
        human9.setAddress(address6);

        Address address7 = new Address("Москва", "Евтушеннко", "1", null);
        Human human10 = new Human();
        human10.setFio("Евтушеннко Евгенний Алексарндрович");
        human10.setAge(84);
        human10.setAddress(address7);

        ArrayList<Human> list = new ArrayList<Human>(10);
        list.add(human1);
        list.add(human2);
        list.add(human3);
        list.add(human4);
        list.add(human5);
        list.add(human6);
        list.add(human7);
        list.add(human8);
        list.add(human9);
        list.add(human10);

        return list;
    }

    public static List<Human> getDuplicates(List<Human> a) {
        List<Human> dublicates = new ArrayList<Human>();
        for (int i = 0; i < a.size(); i++) {
            Human e1 = a.get(i);
            if (e1 == null) continue;
            for (int j = i+1; j < a.size(); j++) {
                if (i == j) continue;
                Human e2 = a.get(j);
                if (e1.equals(e2)) {
                    dublicates.add(e2);
                }
            }
        }
        return dublicates;
    }

    public static ArrayList<Human> task1(){
        return Do.getHumanList();
    }

    public static List<Human> task2(ArrayList<Human> mainList){
        return Do.getDuplicates(mainList);
    }

    public static void task3(List<Human> dublicatesList, ArrayList<Human> mainList){
        for (Human d : dublicatesList){
            System.out.println("dublicate: " + d.getFio());
            mainList.remove(d);
        }
        for (Human h : mainList){
            System.out.println(h.fio);
        }
    }

    public static void task4(ArrayList<Human> mainList){
        Collections.sort(mainList, new ComparatorFIO());
    }

    public static void task5(ArrayList<Human> mainList) {
        Collections.sort(mainList, new ComparatorAge());
    }

    public static void task6(ArrayList<Human> mainList) {
        Collections.sort(mainList, new ComparatorAddress());
    }

    public static Map<String,Integer> createMap(){
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("3",3);
        map.put("1",1);
        map.put("4",4);
        map.put("8",8);
        map.put("6",6);
        return map;
    }

    public static void task9() {
        Map<String,Integer> map = createMap();
        List sortKeys = new ArrayList(map.keySet()); //возможно не это было нужно
        System.out.println("sorted Map by keys: " + sortKeys);
    }

    public static void task10() {
        Map<String,Integer> map = createMap();
        List sortValues = new ArrayList(map.values()); //возможно не это было нужно
        System.out.println("sorted Map by values: " + sortValues);
    }
}
