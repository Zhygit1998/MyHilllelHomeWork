public interface CacheInterface {

    boolean put(String value, String key, Object o);

    Object get (String value, String key);

    void clear();

    void clear(String value);

}
