public interface Deque<Item> {

    void printDeque();

    Item getRecursive(int i);

    Item removeFirst();

    Item removeLast();

    void addFirst(Item item);

    void addLast(Item item);

    boolean isEmpty();

    Item get(int index);

    int size();
}
