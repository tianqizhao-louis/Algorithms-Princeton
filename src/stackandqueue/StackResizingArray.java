package src.stackandqueue;

public class StackResizingArray {
    private String[] s;
    private int N;
    public StackResizingArray() {
        s = new String[1];
        this.N = 0;
    }

    public void push(String item) {
        if (N == s.length) {
            resize(2 * s.length);
        }
        s[N++] = item;
    }

    private void resize(int cap) {
        String[] copy = new String[cap];
        for (int i = 0; i < N; i++) {
            copy[i] = s[i];
        }
        s = copy;
    }
}
