package com.rezaramadhanirianto.dsaImpl.datastructures.unionfind;

// UnionFind basically is same as Disjoint set
public class UnionFind {
    private int data[];
    private int size[];
    private int capacity;
    //sisa;
    private int numComponents;

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

    public boolean connected(int p, int q){
        int root_p = find(p);
        int root_q = find(q);
        return root_p == root_q;
    }

    public int find(int p){
        int root = p;
        while(root != data[root]) root = data[root];

//        // COmpress to O[1]
        while (data[p] != root) {
            int next = data[p];
            data[p] = root;
            p = next;
        }

        return root;
    }


    public void unify(int p, int q){
        if (connected(p, q)) return;

        int rootP = find(p);
        int rootQ = find(q);

        if(size[rootP] > size[rootQ]){
            size[rootP] += size[rootQ];
            data[rootQ] = rootP;
            size[rootQ] = 0;
        }else{
            size[rootQ] += size[rootP];
            data[rootP] = rootQ;
            size[rootP] = 0;
        }

        numComponents--;
    }

}
