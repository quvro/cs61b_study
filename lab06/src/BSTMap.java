import java.util.Iterator;
import java.util.Set;

public class BSTMap<K, V> implements Map61B<K, V>{
    int size;
    Node tree;

    private class Node {
        K key;
        V value;
        Node left;
        Node right;

        private Node(K k, V v) {
            key = k;
            value = v;
            left = null;
            right = null;
        }
    }

    public BSTMap() {
        size = 0;
    }

    @Override
    public void put(Object key, Object value) {
        if (tree == null) {
            tree = new Node((K)key, (V)value);
        }

    }

    @Override
    public Object get(Object key) {
        if (tree == null) {
            return null;
        }

        return null;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {

    }

    @Override
    public Set keySet() {
        return Set.of();
    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }
}
