
import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {

    @Test
    public void test01() {

        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> sol1 = new ArrayDequeSolution<>();

        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                sad1.addLast(i);
                sol1.addLast(i);
            } else {
                sad1.addFirst(i);
                sol1.addFirst(i);
            }
        }

        for (int i = 0; i < 10; i += 1) {

            System.out.println(i);
            double numberBetweenZeroAndOne = StdRandom.uniform();
            Integer actual = null;
            Integer expected = null;

            if (numberBetweenZeroAndOne < 0.5) {
                actual = sad1.removeLast();
                expected = sol1.removeLast();
            } else {
                actual = sad1.removeFirst();
                expected = sol1.removeFirst();
            }

            assertEquals("Oh noooo!\nThis is bad:\n   Random number " + actual
                            + " not equal to " + expected + "!",
                    expected, actual);
        }



//        sad1.printDeque();
//        System.out.println("*************");
//        System.out.println(sad1.removeFirst());
//        System.out.println(sad1.removeFirst());
//        System.out.println(sad1.removeFirst());
//        sol1.removeFirst();
//        sol1.removeFirst();
//        sol1.removeFirst();
//
//        Integer actual = sad1.removeLast();
//        Integer expected = sol1.removeLast();
//        assertEquals("Oh noooo!\nThis is bad:\n   Random number " + actual
//                        + " not equal to " + expected + "!",
//                expected, actual);
//        System.out.println("*************");
//        sad1.printDeque();
        //--------




    }
}
