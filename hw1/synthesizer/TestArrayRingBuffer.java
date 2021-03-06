package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {

    @Test
    public void myTest() {

        ArrayRingBuffer<Double> buffer = new ArrayRingBuffer<Double>(50);
        int index = buffer.capacity();

        while (index > 0) {

            double r = Math.random() - 0.5;
            buffer.enqueue(r);
            index--;
        }

        index = buffer.capacity();

        while (index > 0) {

            System.out.println(index);
            Double a = buffer.dequeue();
            Double b = buffer.peek();
            Double c = (a + b) / 2;
            buffer.enqueue(c);
            index--;
        }
    }

    @Test
    public void someTest() {
        ArrayRingBuffer<Double> x = new ArrayRingBuffer<Double>(4);
        x.enqueue(33.1); // 33.1 null null  null
        x.enqueue(44.8); // 33.1 44.8 null  null
        x.enqueue(62.3); // 33.1 44.8 62.3  null
        x.enqueue(-3.4); // 33.1 44.8 62.3 -3.4
        Double d = x.dequeue();     // 44.8 62.3 -3.4  null (returns 33.1)
        System.out.println(d);
        x.enqueue(4.0);
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
