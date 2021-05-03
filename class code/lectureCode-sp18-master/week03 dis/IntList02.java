public class IntList02 {

    public int first;
    public IntList rest;

    public IntList02(int f, IntList r) {
        this.first = f;
        this.rest = r;
    }

    /**
     * Given a sorted linked list of items - remove duplicates. For example given 1
     * -> 2 -> 2 -> 2 -> 3, Mutate it to become 1 -> 2 -> 3 (destructively)
     */
    public static void removeDuplicates(IntList p) {

        if (p == null) {
            return;
        }

        IntList current = p.rest;
        IntList previous = p;

        while (current != null) {

            if (previous.first == current.first) {
                previous.rest = current.rest;
            } else {
                previous = current;
            }

            current = current.rest;
        }
    }
}
