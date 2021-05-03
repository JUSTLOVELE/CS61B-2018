import java.util.ArrayList;
import java.util.List;

public class SLList {

    private class IntNode {

        public int item;

        public IntNode next;

        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }

    private IntNode first;

    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    public void initTest() {

        first = new IntNode(1, first);
        IntNode n04 = new IntNode(4, null);
        IntNode n03 = new IntNode(3, n04);
        IntNode n02 = new IntNode(2, n03);
        first.next = n02;
    }

    public void toNode() {

        IntNode temp = first;
        while (temp != null) {

            System.out.print(temp.item + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        SLList slList = new SLList();
        slList.initTest();
        slList.reverse();
        slList.toNode();
    }

    public void reverse() {

        IntNode frontOfReversed = null;
        IntNode nextNodeToAdd = first;

        while (nextNodeToAdd != null) {

            IntNode remainderOfOriginal = nextNodeToAdd.next;
            nextNodeToAdd.next = frontOfReversed;
            frontOfReversed = nextNodeToAdd;
            nextNodeToAdd = remainderOfOriginal;
        }

        first = frontOfReversed;
    }

    public void reverse02() {
        first = reverseRecursiveHelper(first);
    }

    private IntNode reverseRecursiveHelper(IntNode front) {

        if (front == null || front.next == null) {
            return front;
        } else {
            IntNode reversed = reverseRecursiveHelper(front.next);
            front.next.next = front;
            front.next = null;
            return reversed;
        }
    }

    /**
     * 实现insert For example, if the SLList is 5 → 6 → 2, insert(10, 1) results in 5
     * → 10 → 6 → 2.
     * 
     * @param item
     * @param position
     */
    public void insert(int item, int position) {

        if (first == null || position == 0) {
            addFirst(item);
            return;
        }

        IntNode currentNode = first;
        while (position > 1 && currentNode.next != null) {
            position--;
            currentNode = currentNode.next;
        }

        IntNode newNode = new IntNode(item, currentNode.next);
        currentNode.next = newNode;
    }
}