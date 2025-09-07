package hashmap;

import java.util.*;

/**
 *  A hash table-backed Map implementation.
 *
 *  Assumes null keys will never be inserted, and does not resize down upon remove().
 *  @author YOUR NAME HERE
 */
public class MyHashMap<K, V> implements Map61B<K, V> {

    @Override
    public void put(K key, V value) {
        if ((double)size / (double)capacity > loadFactor) {
            resize();
        }
        Node newNode = new Node(key, value);
        int bucketNum = Math.floorMod(newNode.key.hashCode(), capacity);

        if (containsKey(key)) {
            for (Node node : buckets[bucketNum]) {
                if (node.key.equals(key)) {
                    node.value = value;
                    return;
                }
            }
        }
        buckets[bucketNum].add(newNode);
        size ++;
    }

    private void resize() {
        capacity *= 2;
        Collection<Node>[] newBuckets = new Collection[capacity];
        for (int i = 0; i < capacity; i ++) {
            newBuckets[i] = createBucket();
        }
        for (int i = 0; i < capacity / 2; i ++) {
            for (Node node : buckets[i]) {
                int bucketNum = Math.floorMod(node.key.hashCode(), capacity);
                newBuckets[bucketNum].add(node);
            }
        }

        buckets = newBuckets;
    }

    @Override
    public V get(K key) {
        int bucketNum = Math.floorMod(key.hashCode(), capacity);
        for (Node node : buckets[bucketNum]) {
            if (key.equals(node.key)) {
                return node.value;
            }
        }
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        for (int i = 0; i < capacity; i ++) {
            for (Node node : buckets[i]) {
                if (key.equals(node.key)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int size() {return size;}

    @Override
    public void clear() {
        capacity = 16;
        buckets = new Collection[capacity];
        for(int i = 0; i < capacity;i++){
            buckets[i] = createBucket();
        }
        size = 0;
    }

    @Override
    public Set<K> keySet() {
        Set<K> newKeySet = new HashSet<>();
        for (int i = 0; i < capacity; i ++) {
            for (Node node : buckets[i]) {
                newKeySet.add(node.key);
            }
        }
        return newKeySet;
    }

    @Override
    public V remove(K key) {
        if (containsKey(key)) {
            for (int i = 0; i < capacity; i ++) {
                for (Node node : buckets[i]) {
                    if (key.equals(node.key)) {
                        V nodeValue = node.value;
                        buckets[i].remove(node);
                        return nodeValue;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }



    protected class Node {
        K key;
        V value;

        Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    /** Instance Variables */
    private int size = 0; // num of items
    private Collection<Node>[] buckets;
    private int capacity = 16; // num of buckets
    private double loadFactor = 0.75;

    /** Constructors */
    public MyHashMap() {
        buckets = new Collection[capacity];
        for (int i = 0; i < capacity; i ++) {
            buckets[i] = createBucket();
        }
    }

    public MyHashMap(int initialCapacity) {
        capacity = initialCapacity;
        buckets = new Collection[initialCapacity];
        for (int i = 0; i < initialCapacity; i ++) {
            buckets[i] = createBucket();
        }
    }

    public MyHashMap(int initialCapacity, double loadFactor) {
        capacity = initialCapacity;
        this.loadFactor = loadFactor;
        buckets = new Collection[initialCapacity];
        for (int i = 0; i < initialCapacity; i ++) {
            buckets[i] = createBucket();
        }
    }

    /** Create buckets */
    protected Collection<Node> createBucket() {
        return new LinkedList<>();
    }

}
