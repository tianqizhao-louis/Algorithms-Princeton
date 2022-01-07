package src.quickfinddemo1;

public class PathCompressionUF {
    private int[] id;
    private int[] sz;

    public PathCompressionUF(int N){
        this.id = new int[N];
        this.sz = new int[N];

        for (int i = 0; i < N; i++){
            this.id[i] = i;
            this.sz[i] = i;
        }
    }

    private int root(int i){
        while (i != this.id[i]){
            // Only one extra line of code
            this.id[i] = this.id[this.id[i]];
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

        if (i == j){
            return;
        }

        if (this.sz[i] < this.sz[j]){
            this.id[i] = j;
            this.sz[j] += this.sz[i];
        }else {
            this.id[j] = i;
            this.sz[i] += this.sz[j];
        }
    }
}
