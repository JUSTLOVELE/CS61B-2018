import java.util.Stack;

public class SortedStack<Item extends Comparable<Item>> {

    private Stack<Item> a;

    private Stack<Item> b;

    public SortedStack() {
        a = new Stack<>();
        b = new Stack<>();
    }

    public void push(Item t) {

        while (!a.empty() && a.peek().compareTo(t) < 0) {
            b.push(a.poll());
        }
        a.push(t);
        while (!b.empty()) {
            a.push(b.poll());
        }
    }

    public Item poll() {
        return a.poll();
    }
}
