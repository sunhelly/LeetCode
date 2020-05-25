package leetcode.algorithms;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 146
 */
public class LRUCache {

    private Map<Integer, Integer> map;

    private float factor = 0.75f;

    private int cacheSize;

    public LRUCache(final int cacheSize) {
        this.cacheSize = cacheSize;
        int capacity = (int) Math.ceil(cacheSize / factor) + 1;
        map = new LinkedHashMap<Integer, Integer>(capacity, factor, true) {

            @Override
            public boolean removeEldestEntry(Map.Entry<Integer, Integer> entry) {
                return size() > LRUCache.this.cacheSize;
            }
        };
    }

    public synchronized int get(int key) {
        Integer result = map.get(key);
        return result == null ? -1 : result;
    }

    public synchronized void put(int key, int value) {
        map.put(key, value);
    }
}