import java.util.Stack;

public class Deque<Item> {

    private Stack<Item> a;

    private Stack<Item> b;

    public Deque() {
        a = new Stack<>();
        b = new Stack<>();
    }

    public void push(Item t) {
        while (!a.empty()) {
            b.push(a.poll());
        }
        a.push(t);
        while (!b.empty()) {
            a.push(b.poll());
        }
    }

    public Item poll() {
        a.poll();
    }

}
