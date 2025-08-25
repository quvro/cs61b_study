public class UnionFind {
    // TODO: Instance variables
    private int[] id;
    private int size;

    /* Creates a UnionFind data structure holding N items. Initially, all
       items are in disjoint sets. */
    public UnionFind(int N) {
        // TODO: YOUR CODE HERE
        id = new int[N];
        size = N;
        for (int i = 0; i < N; i ++) {
            id[i] = -1;
        }
    }

    /* Returns the size of the set V belongs to. */
    public int sizeOf(int v) {
        // TODO: YOUR CODE HERE
        return id[find(v)];
    }

    /* Returns the parent of V. If V is the root of a tree, returns the
       negative size of the tree for which V is the root. */
    public int parent(int v) {
        // TODO: YOUR CODE HERE
        return id[v];
    }

    /* Returns true if nodes/vertices V1 and V2 are connected. */
    public boolean connected(int v1, int v2) {
        // TODO: YOUR CODE HERE
        return find(v1) == find(v2);
    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. If invalid items are passed into this
       function, throw an IllegalArgumentException. */
    public int find(int v) {
        // TODO: YOUR CODE HERE
        if (v >= size) {
            throw new IllegalArgumentException("Out of bounds.");
        }
        if (parent(v) < 0) {
            return v;
        } else {
            id[v] = find(parent(v));
            return find(parent(v));
        }
    }

    /* Connects two items V1 and V2 together by connecting their respective
       sets. V1 and V2 can be any element, and a union-by-size heuristic is
       used. If the sizes of the sets are equal, tie break by connecting V1's
       root to V2's root. Union-ing an item with itself or items that are
       already connected should not change the structure. */
    public void union(int v1, int v2) {
        // TODO: YOUR CODE HERE
        int root1 = find(v1), root2 = find(v2);
        if (root1 == root2) {
            return;
        }
        if (sizeOf(v1) >= sizeOf(v2)) {
            id[root2] += sizeOf(v1);
            id[root1] = root2;
        } else {
            id[root1] += sizeOf(v2);
            id[root2] = root1;
        }
    }

}
