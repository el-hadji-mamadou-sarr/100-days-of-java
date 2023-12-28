package com.dsa;

public class UnionFind {
    // number of elems in the union find
    private int size;

    // the number of elems in each components
    private int[] sz;

    // to track the parent node like component i have parent id[i] if id[i]=i so i
    // is the parent node
    private int[] id;

    private int numComponents;

    public UnionFind(int size) {
        if (size <= 0)
            throw new IllegalArgumentException();
        this.size = numComponents = size;

        id = new int[size];
        sz = new int[size];

        for (int i = 0; i < size; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    // find which component the node belongs to and then amortise
    // that mean find the root node
    public int find(int p) {
        int root = p;
        while (root != id[root]) {
            root = id[root];
        }
        // now we can compress the path to have amortised constant time.
        while (p != root) {
            int next = id[p];
            id[p] = root;
            p = next;
        }
        return root;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int sizeComponent(int p) {
        return sz[find(p)];
    }

    public int size() {
        return size;
    }

    public int numComponents() {
        return numComponents;
    }

    // unify components/sets
    public void unify(int p, int q) {
        int root1 = find(p);
        int root2 = find(q);

        if (root1 != root2) {
            // merge smaller component into larger one
            if (sz[root1] < sz[root2]) {
                sz[root2] += sz[root1];
                id[root1] = root2;
            } else {
                sz[root1] += sz[root2];
                id[root2] = root1;
            }
            numComponents--;
        }

    }

}
