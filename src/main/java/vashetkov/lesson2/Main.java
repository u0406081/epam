package vashetkov.lesson2;

public class Main {
    public static void main(String[] args) throws Exception {

        Cache<Integer> cache = new Cache(5);
        cache.add(1);
        cache.add(2);
        cache.add(3);
        cache.add(4);
        cache.add(5);

        //cache.delete(2);
        //System.out.println("isPresent = " + cache.isPresent(6));
        //cache.get(2);
        //cache1.clear();

        for (int i=0; i<10; i++) {
            System.out.println(cache.getCache()[i]);
        }
    }
}