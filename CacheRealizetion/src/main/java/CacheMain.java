import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Сaching implementation in Java
 *
 * @author Pavel Zhigit
 * @version 1.0
 *
 */
public class CacheMain implements CacheInterface {
    /**
     * Log creation
     */
    private static final Logger log = Logger.getLogger(CacheMain.class);
    /**
     * creating the main Map in project
     */
    private Map<String, Map<String, Object>> cacheMap;

    /**
     * constructor for initialization main Map
     */
    public CacheMain() {
        this.cacheMap = new HashMap<>();
    }

    /**
     * put object in cache
     *
     * @param cache - name of cache;
     * @param key   - the key for object we cache;
     * @param o     - the object we want put to the cache
     * @return - return the value true or false
     */
    @Override
    public boolean put(String cache, String key, Object o) {
        Map<String, Object> valueMap;
        if (!cacheMap.containsKey(cache)) {
            valueMap = new HashMap<>();
            valueMap.put(key, o);
            cacheMap.put(cache, valueMap);
            log.info("Create cache with name " + cache);
        } else if (cacheMap.containsKey(cache) && cacheMap.get(cache).containsKey(key)) {
            if (cacheMap.get(cache).get(key).equals(o)) {
                log.error("Such a cache already exists!");
                return false;
            }
            valueMap = cacheMap.get(cache);
            valueMap.put(key, o);
            cacheMap.put(cache, valueMap);
            log.warn("Add new key!");
        } else {
            valueMap = cacheMap.get(cache);
            valueMap.put(key, o);
            cacheMap.put(cache, valueMap);

        }
        log.info("Object " + o + " put to cache " + cache);
        return cacheMap.containsKey(cache) && cacheMap.get(cache).equals(valueMap);
    }


    /**
     * get information from the chosen cache with chosen key
     *
     * @param cache - name of cache;
     * @param key   - the key for object we cache;
     * @return - returns value by key
     */
    @Override
    public Object get(String cache, String key) {
        if (cacheMap.containsKey(cache) && (cacheMap.get(cache) != null)) {
            Map<String, Object> valueMap;
            valueMap = cacheMap.get(cache);
            if (valueMap.containsKey(key)) {
                log.info("return object from cache " + cache + " with key - " + key);
                return valueMap.get(key);
            } else {
                log.warn("Key is not exist");
            }
        } else {
            log.error("Cash is not exist");
        }
        return null;
    }

    /**
     * full cleaning of cache
     */
    @Override
    public void clear() {
        if (cacheMap.size() == 0) {
            log.warn("Cache empty!");
        } else {
            cacheMap = new HashMap<>();
            log.info("The cache is cleared");
        }
    }

    /**
     * clearing the entire cache
     *
     * @param cache - the name of cache for cleaning
     */
    @Override
    public void clear(String cache) {
        if (!cacheMap.isEmpty()) {
                cacheMap.remove(cache);
                log.info("The cash - " + cache + " is removed");
        } else {
            log.error("Cache with a name - " + cache + "is missing" );
        }
    }

    /**
     * @return size - returns the number of items in the cache
     * @since 1.0
     */
    public int mapSize() {
        int size = cacheMap.size();
        log.info("the cache size - " + size);
        return size;
    }
}
