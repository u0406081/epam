package vashetkov.lesson2;
import vashetkov.lesson2.MyExceptions.MyCheckedException;


public class Main {
    public static void main(String[] args){


        Cache<Integer> cache1 = new Cache<Integer>(5);

        CacheElement<Integer> element1 = new CacheElement<Integer>();
        element1.element = 1;
        CacheElement<Integer> element2 = new CacheElement<Integer>();
        element2.element = 2;
        CacheElement<Integer> element3 = new CacheElement<Integer>();
        element3.element = 3;
        CacheElement<Integer> element4 = new CacheElement<Integer>();
        element4.element = 4;
        CacheElement<Integer> element5 = new CacheElement<Integer>();
        element5.element = 5;
        CacheElement<Integer> element6 = new CacheElement<Integer>();
        element6.element = 6;

        Storage storage = new Storage();

        cache1.add(null);
        cache1.add(element1);
        cache1.add(element2);
        cache1.add(element3);
        cache1.add(element4);
        cache1.add(element5);
        //cache1.add(element6);

        try {
            cache1.delete(element6);
        } catch (MyCheckedException e) {
            System.out.println("Element is null");
        }
        //System.out.println("isPresent = " + cache1.isPresent(element6));
        //cache1.get(element2);
        //cache1.clear();

        for (int i=0; i<5; i++) {
            CacheElement<Integer> el = cache1.get()[i];
            if (el != null) {
                System.out.println(el.element);
            }else{
                System.out.println("null");
            }
        }


    }
}