package Leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author ：mzr
 * @date ：Created in 2020/5/7 11:11
 * @description：实现LRU机制
 * @modified By：
 */

public class LRUCache extends LinkedHashMap<Integer,Integer> {

    private int capacity;

    public LRUCache(int capacity) {
//        按访问时间排序，先访问的在前面
        super(capacity,0.75F,true);
        this.capacity = capacity;
    }

    public int get(int key) {
//        当没有找到key时，返回默认值-1
        return super.getOrDefault(key,-1);
    }

    public void put(int key, int value) {
//        插入链表末尾
        super.put(key,value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
//        当大于现在的容量是，就删除头结点
        return size() > capacity;
    }


}

