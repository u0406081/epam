package vashetkov.lesson2;
/**
 * Класс кэш.
 * @autor 123
 * @version 1.0
 */
public class Cache<T> {
    private CacheElement<T>[] cache = null;
    private int capacity;
    private int size = 0;
    Cache(int capacity){
        this.capacity = capacity;
        cache = new CacheElement[capacity];
    }

    /**
     * Добавляет
     * @param element - элемент
     */
    public void add(CacheElement<T> element){
        if (size==capacity){
            for (int j = 0; j < cache.length - 1; j++) {
                cache[j] = cache[j + 1];
            }
            cache[cache.length-1] = (CacheElement<T>)element;
        }else{
            cache[size] = (CacheElement<T>)element;
            size++;
        }
    }

    /**
     * Удаляет
     * @param element - элемент
     */
    public void delete(CacheElement<T> element) throws Exception {
        Integer indexOfFinded = null;
        for (int i=0; i < cache.length; i++) {
            if (cache[i] != null && cache[i].equals(element)) {
                indexOfFinded = i;
                cache[i] = null;
            }
        }
        if (indexOfFinded == null) throw new Exception("Element not found");
        for (int i=indexOfFinded; i < cache.length-1; i++){
            cache[i] = cache[i+1];
            cache[i+1] = null;
        }
    }

    /**
     * Проверяет на существование
     * @param element - элемент
     */
    public boolean isPresent(CacheElement<T> element){
        Object o;
        for (int i=0; i < cache.length; i++){
            o = cache[i];
            if (o != null && o.equals(element)) return true;
        }
        return false;
    }

    /**
     * Достаёт
     * @param element - элемент
     */
    public T get(CacheElement<T> element){
        Integer indexOfFinded = null;
        T findedObject = null;
        for (int i=0; i < cache.length; i++) {
            if (cache[i] != null && cache[i].equals(element)) {
                indexOfFinded = i;
                findedObject = (T) cache[i];
                cache[i] = null;
            }
        }
        if (indexOfFinded == null) return null;
        for (int i=indexOfFinded; i < cache.length-1; i++){
            cache[i] = cache[i+1];
            cache[i+1] = null;
        }
        cache[cache.length-1] = (CacheElement<T>)findedObject;
        return  findedObject;
    }

    /**
     * Чистит
     */
    public void clear(){
        for (int i=0; i < cache.length; i++){
            cache[i] = null;
        }
    }

    /**
     * Возвращает
     * @return объект кэш
     */
    CacheElement<T>[] get(){
        return cache;
    }
}
