public class LinkedListDeque<T> {

    class Node {

        public Node() {

        }

        public Node (T value ) {
            this.value = value;
        }

        public Node prev;
        public Node next;
        public T value;
        public String v;
    }

    private int size = 0;

    private Node sentinel;
    //用first、last就是表示用2个哨兵，课件推荐使用1个的形式
    private Node first;

    private Node last;

    /**
     * Creates an empty linked list deque.
     */
    public LinkedListDeque() {
        sentinel = new Node();
        sentinel.v = "sentinel";
    }

    /**
     * Same as get, but uses recursion.
     * @param index
     * @return
     */
    public T getRecursive(int index) {

        if (index < 0 || index > size - 1) {
            return null;
        }

        Node n = recurive(sentinel, index);
        return n.value;
    }

    private Node recurive(Node n, int index) {

        if (index < 0) {
            return n;
        }

        return recurive(n.next, index - 1);
    }

    /**
     * Adds an item of type T to the front of the deque
     * @param item
     */
    public void addFirst(T item) {

        Node itemNode = new Node(item);
        Node next = sentinel.next;

        if (next != null) {
            next.prev = itemNode;
        }

        sentinel.next = itemNode;
        itemNode.prev = sentinel;
        itemNode.next = next;
        size++;
    }

    /**
     * Adds an item of type T to the back of the deque
     * @param item
     */
    public void addLast(T item) {

        Node itemNode = new Node(item);
        Node n = sentinel;
        int index = size;

        while (index > 0) {
            n = n.next;
            index--;
        }

        n.next = itemNode;
        itemNode.next = sentinel;
        itemNode.prev = n;
        size++;
    }

    /**
     * Returns true if deque is empty, false otherwise.
     * @return
     */
    public boolean isEmpty() {

        if (size == 0) {
            return true;
        }

        return false;
    }

    /**
     * Returns the number of items in the deque.
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space.
     */
    public void printDeque() {

        Node n = sentinel;
        int index = size;

        while (index > 0) {
            System.out.print(n.next.value + " ");
            n = n.next;
            index--;
        }

        System.out.println();
    }

    /**
     * Removes and returns the item at the front of the deque. If no such item exists, returns null.
     * @return
     */
    public T removeFirst() {

        if (isEmpty()) {
            return null;
        }

        Node firstNode = sentinel.next;
        size--;

        if (firstNode.next != null) {

            Node secondNode = first.next;
            sentinel.next = secondNode;
            secondNode.prev = sentinel;

        } else {
            sentinel.next = null;
        }

        return firstNode.value;
    }

    /**
     * Removes and returns the item at the back of the deque. If no such item exists, returns null.
     * @return
     */
    public T removeLast() {

        if (isEmpty()) {
            return null;
        }

        Node lastNode = sentinel;
        int index = size;

        while (index > 0) {
            lastNode = lastNode.next;
            index--;
        }

        Node lastSecondNode = lastNode.prev;
        lastSecondNode.next = sentinel;
        lastNode.next = null;
        lastNode.prev = null;
        size--;

        return lastNode.value;
    }

    /**
     *  Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     *  If no such item exists, returns null. Must not alter the deque!
     * @param index
     * @return
     */
    public T get(int index) {

        if (index < 0 || index > size - 1) {
            return null;
        }

        Node lastNode = sentinel;

        while (index > 0) {
            lastNode = lastNode.next;
            index--;
        }


        return lastNode.value;
    }
}
