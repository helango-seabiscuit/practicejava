package com.hemalatha.IK.LinkedList;


import java.util.HashMap;
import java.util.Map;

class CacheHolder {
    int key;
    int value;
    CacheHolder previous;
    CacheHolder next;

    CacheHolder(int key,int value){
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public CacheHolder getPrevious() {
        return previous;
    }

    public void setPrevious(CacheHolder previous) {
        this.previous = previous;
    }

    public CacheHolder getNext() {
        return next;
    }

    public void setNext(CacheHolder next) {
        this.next = next;
    }
}

public class LRUCache {

    private Map<Integer,CacheHolder> holderMap;
    private int size,capacity;
    CacheHolder head,tail;

    LRUCache(int capacity){
        holderMap = new HashMap<>();
        this.capacity = capacity;
    }

    public void set(int key,int value){
       if(holderMap.get(key)==null){
           if(size==capacity){
               holderMap.remove(evict().getKey());
           }
           CacheHolder cacheHolder = new CacheHolder(key,value);
           addToCacheHead(cacheHolder);
           holderMap.put(key,cacheHolder);
       }
    }

    public Integer get(int key){
       if(holderMap.get(key)!=null){
           CacheHolder cacheHolder = holderMap.get(key);
           removeFromCache(cacheHolder);
           addToCacheHead(cacheHolder);
         return holderMap.get(key).getValue();
       }
       return null;
    }

    public boolean remove(int key){
        if(holderMap.get(key)!=null){
            removeFromCache(holderMap.get(key));
            holderMap.remove(key);
            return true;
        }
        return false;
    }

    private CacheHolder evict(){
        size--;
        if(tail==head){
            CacheHolder temp = head;
            tail = head = null;
            return temp;
        }

        tail.getPrevious().setNext(null);
        CacheHolder temp = tail;
        tail = tail.getPrevious();
        temp.setPrevious(null);
        return temp;
    }

    private void addToCacheHead(CacheHolder cacheHolder){
        size++;
        if(head==null){
            head = cacheHolder;
            tail = cacheHolder;
            return;
        }
        cacheHolder.setNext(head);
        head.setPrevious(cacheHolder);
        head = cacheHolder;
    }

    private void removeFromCache(CacheHolder cacheHolder){
        size--;
        if(head == cacheHolder){
            head = head.getNext();
            if(tail == cacheHolder){
                tail = null;
            }
            return;
        }
        cacheHolder.getPrevious().setNext(cacheHolder.getNext());
        if(cacheHolder.getNext()!=null) {
            cacheHolder.getNext().setPrevious(cacheHolder.getPrevious());
        }else{
            tail = cacheHolder.getPrevious();
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.set(1,4);
        lruCache.set(2,8);
        lruCache.set(3,6);
        System.out.println(lruCache.size);
        lruCache.get(1);
        lruCache.remove(1);
    }
}
