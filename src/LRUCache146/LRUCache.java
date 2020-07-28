package LRUCache146;

import java.util.*;

/**
 * 链表实现，最久未使用的数据key放到前面，访问过的数据key移动到表尾
 * Map保存key-value对
 */
public class LRUCache {
    private LinkedList<Integer> keylist;
    private Map<Integer, Integer> map;
    private int capacity;
    private int curnum;
    public LRUCache(int capacity) {
        keylist = new LinkedList<>();
        map = new HashMap<>();
        this.capacity = capacity;
        curnum = 0;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            keylist.remove(Integer.valueOf(key));
            keylist.addLast(key);
            return map.get(key);
        }
        else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            keylist.remove(Integer.valueOf(key));
            keylist.addLast(key);
        }
        else {
            if (curnum >= capacity) {
                map.remove(keylist.getFirst());
                keylist.removeFirst();
            }
            map.put(key, value);
            keylist.addLast(key);
            ++curnum;
        }
    }
}
/**
 * 可用LinkedHashMap
 */
class LRUCache2 {

    private int cap;
    private Map<Integer, Integer> map = new LinkedHashMap<>();  // 保持插入顺序

    public LRUCache2(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        if (map.keySet().contains(key)) {
            int value = map.get(key);
            map.remove(key);
            // 保证每次查询后，都在末尾
            map.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.keySet().contains(key)) {
            map.remove(key);
        } else if (map.size() == cap) {
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            iterator.next();
            iterator.remove();
        }
        map.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
