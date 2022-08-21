package com.rezaramadhanirianto.dsaImpl.datastructures.unionfind;

// UnionFind / Disjoint Set
public class UnionFind {
    private int data[];
    private int size[];
    private int capacity;

    //remaining number
    private int numComponents;

    // basically we should add size, this is impact we how many nodes/vertices we have
    // 4 -> [0, 1, 2, 3]
    public UnionFind(int size){
        if(size == 0) throw new RuntimeException("Size cannot be 0");
        capacity = numComponents = size;

        data = new int[size];
        this.size = new int[size];
        for(int i = 0; i < size; i++){
            data[i] = i;
            this.size[i] = 1;
        }
    }

    public int size(){
        return capacity;
    }

    public int components(){
        return numComponents;
    }

    public int componentSize(int p){
        return size[find(p)];
    }

    // check is connected if they have same parent
    public boolean connected(int p, int q){
        int root_p = find(p);
        int root_q = find(q);
        return root_p == root_q;
    }

    // Unify is function that merge two graph
    // unify(0,1)
    // [1,1,2,3]
    // unify(2,3)
    // [1,1,3,3]
    // unify(0,2)
    // [1,3,3,3]
    // -- Graph Apperance --
    //   3
    //  /  \
    // 1    2
    // |
    // 0
    public int find(int p){
        int root = p;
        while(root != data[root]) root = data[root];
        return root;
    }


    public void unify(int p, int q){
        if (connected(p, q)) return;

        // find respective root
        int rootP = find(p);
        int rootQ = find(q);

        if(size[rootQ] > size[rootP]){
            size[rootQ] += size[rootP];
            data[rootP] = rootQ;
            size[rootP] = 0;
        }else{
            size[rootP] += size[rootQ];
            data[rootQ] = rootP;
            size[rootQ] = 0;
        }

        numComponents--;
    }

    public int[] getData(){
        return data;
    }

}
