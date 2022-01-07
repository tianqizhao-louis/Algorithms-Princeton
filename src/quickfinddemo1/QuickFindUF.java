/*
* Quick-find is too slow: O(N^2)
* */

package src.quickfinddemo1;

public class QuickFindUF {
    private int[] id;

    public QuickFindUF(int N){
        this.id = new int[N];
        for(int i = 0; i < N; i++){
            this.id[i] = i;
        }
    }

    public boolean connected(int p, int q){
        return this.id[p] == this.id[q];
    }

    public void union(int p, int q){
        int pid = this.id[p];
        int qid = this.id[q];

        for (int i = 0; i < this.id.length; i++){
            if (this.id[i] == pid){
                this.id[i] = qid;
            }
        }
    }
}
