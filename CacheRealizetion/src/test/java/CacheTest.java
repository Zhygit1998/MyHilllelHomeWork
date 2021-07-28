import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

    public class CacheTest {
        @Test
        public void testPut() {
            CacheMain cache = new CacheMain();
            assertTrue(cache.put("primary", "1", "vaz"));
            assertFalse(cache.put("primary", "1", "vaz"));
            assertEquals(1, cache.mapSize());
        }

        @Test
        public void testGet() {
            CacheMain cache = new CacheMain();
            cache.put("primary", "1", "vaz");
            assertEquals("vaz", cache.get("primary", "1"));
            cache.clear();
            assertNull(cache.get("primary", "1"));

        }

        @Test
        public void testClearAll() {
            CacheMain cache = new CacheMain();
            cache.put("primary", "1", "vaz");
            cache.put("secondary", "2", "kamaz");
            cache.put("insignificant", "3", "infinity");
            cache.clear();
            assertNull(cache.get("primary", "1"));
            assertNull(cache.get("secondary", "2"));
            assertNull(cache.get("insignificant", "3"));
            assertEquals(0, cache.mapSize());
        }

        @Test
        public void testValueClear() {
            CacheMain cache = new CacheMain();
            cache.put("primary", "1", "vaz");
            cache.put("secondary", "2", "kamaz");
            cache.put("insignificant", "3", "infinity");
            cache.clear("secondary");
            assertNull(cache.get("secondary", "2"));
            assertEquals("vaz", cache.get("primary", "1"));
            assertEquals("infinity", cache.get("insignificant", "3"));
            assertEquals(2, cache.mapSize());
        }
}
