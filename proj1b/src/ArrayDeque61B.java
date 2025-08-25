import java.util.List;

public class ArrayDeque61B<T> implements Deque61B<T>{
    private int first = -1;
    private int last = 0;
    private int maxsize = 8;
    private int size = 0;
    private T[] items;

    public ArrayDeque61B() {
        items = (T[]) new Object[8];
    }

    @Override
    public void addFirst(Object x) {
        if (size < maxsize) {
            int idx = Math.floorMod(first, maxsize);
            items[idx] = (T) x;
            first -= 1;
            size += 1;
        }

    }

    @Override
    public void addLast(Object x) {
        if (size < maxsize) {
            items[last] = (T) x;
            last += 1;
            size += 1;
        }
    }

    @Override
    public List toList() {
        return List.of();
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
        return null;
    }

    @Override
    public T removeLast() {
        return null;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T getRecursive(int index) {
        return null;
    }
}
