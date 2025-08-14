import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque61B<T> implements Deque61B<T>{
    private Node sentinel;
    private int size = 0;

    public class Node {
        public T item;
        public Node prev;
        public Node next;

        public Node(T i, Node p, Node n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    public LinkedListDeque61B() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }


    @Override
    public void addFirst(T x) {
        Node NewNode = new Node(x, sentinel, sentinel.next);
        sentinel.next.prev = NewNode;
        sentinel.next = NewNode;
        size += 1;
    }

    @Override
    public void addLast(T x) {
        Node NewNode = new Node(x, sentinel.prev, sentinel);
        sentinel.prev.next = NewNode;
        sentinel.prev = NewNode;
        size += 1;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        Node cur = sentinel.next;
        while (cur != sentinel) {
            returnList.add(cur.item);
            cur = cur.next;
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if (!isEmpty()) {
            Node first = sentinel.next;
            sentinel.next = first.next;
            first.next.prev = sentinel;
            size -= 1;
        }
        return null;
    }

    @Override
    public T removeLast() {
        if (!isEmpty()) {
            Node last = sentinel.prev;
            sentinel.prev = last.prev;
            last.prev.next = sentinel;
            size -= 1;
        }
        return null;
    }

    @Override
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        Node target = sentinel.next;
        while (index > 0) {
            target = target.next;
            index -= 1;
        }
        return target.item;
    }

    @Override
    public T getRecursive(int index) {
        return null;
    }
}
