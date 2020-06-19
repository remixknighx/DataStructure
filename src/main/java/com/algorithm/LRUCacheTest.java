package com.algorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LRUCacheTest {

    public static void main(String[] args) {
        LRUCache<String, String> lruCache = new LRUCache<>();
        lruCache.put("1", "one");
        lruCache.put("2", "two");
        lruCache.put("3", "three");
        lruCache.put("4", "four");
        System.out.println(lruCache.get("1"));
    }

}

class DoubleList<K> {

    List<K> innerList;

    public DoubleList() {
    }

    public DoubleList(int capacity) {
        this.innerList = new LinkedList<>();
    }

    /**
     * 在链表头部添加节点 x，时间 O(1)
     */
    public void addFirst(K x) {
        innerList.add(0, x);
    }

    /**
     * 删除链表中的 x 节点（x 一定存在）
     * 由于是双链表且给的是目标 Node 节点，时间 O(1)
     */
    public void remove(K x) {
        innerList.remove(x);
    }

    /**
     * 删除链表中最后一个节点，并返回该节点，时间 O(1)
     */
    public K removeLast() {
        return innerList.remove(innerList.size() - 1);
    }

    /**
     * 返回链表长度，时间 O(1)
     */
    public int size() {
        return innerList.size();
    }

    public void clear() {
        innerList.clear();
    }
}

class LRUCache<K, V> {

    /**
     * key -> Node(key, val)
     */
    private HashMap<K, V> map;
    /**
     * Node(k1, v1) <-> Node(k2, v2)...
     */
    private DoubleList<K> cache;
    /**
     * 最大容量
     */
    private int cap;
    /**
     * 默认容量
     */
    private static final int DEFAULT_CAPACITY = 3;

    public LRUCache() {
        this(DEFAULT_CAPACITY);
    }

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>(this.cap);
        cache = new DoubleList<>(this.cap);
    }

    public synchronized V get(K key) {
        if (!map.containsKey(key)) {
            return null;
        }
        V val = map.get(key);
        if (val == null) {
            return null;
        }
        // 利用 put 方法把该数据提前
        refreshCache(key, val);
        return val;
    }

    public synchronized void put(K key, V val) {
        // 先把新节点 x 做出来
        if (map.containsKey(key)) {
            refreshCache(key, val);
        } else {
            if (cap == cache.size()) {
                // 删除链表最后一个数据
                K lastKey = cache.removeLast();
                map.remove(lastKey);
            }
            // 直接添加到头部
            cache.addFirst(key);
            map.put(key, val);
        }
    }

    public int size() {
        return map.size();
    }

    public synchronized void clear() {
        cache.clear();
        map.clear();
    }

    private void refreshCache(K key, V val) {
        // 删除旧的节点，新的插到头部
        cache.remove(key);
        cache.addFirst(key);
        // 更新 map 中对应的数据
        map.put(key, val);
    }

}
