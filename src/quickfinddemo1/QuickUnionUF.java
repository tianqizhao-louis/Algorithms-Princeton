/*
* Quick Union:
*   Trees can get too tall
*   Find operation too expensive, could be N array accesses O(N)
* */

package src.quickfinddemo1;

public class QuickUnionUF {
    private int[] id;

    public QuickUnionUF(int N){
        this.id = new int[N];
        for (int i = 0; i < N; i++){
            this.id[i] = i;
        }
    }

    private int root(int i){
        while (i != this.id[i]){
            i = this.id[i];
        }

        return i;
    }

    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

    public void union(int p, int q){
        int i = root(p);
        int j = root(q);

        this.id[i] = j;
    }
}
