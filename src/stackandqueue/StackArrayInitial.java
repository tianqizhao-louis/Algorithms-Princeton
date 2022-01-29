package src.stackandqueue;

public class StackArrayInitial {
    private String[] s;
    private int N = 0;

    public StackArrayInitial(int cap) {
        this.s = new String[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(String item) {
        s[N++] = item;
    }

    public String pop() {
        return s[--N];
    }
}
