package synthesizer;

import java.util.Iterator;
/**
 * 有界队列
 * 只能在队列的后面入队，并且只能从队列的前面出队
 * @param <T>
 */
public interface BoundedQueue<T> extends Iterable<T> {

    int capacity();     // return size of the buffer
    int fillCount();    // return number of items currently in the buffer
    void enqueue(T x);  // add item x to the end
    T dequeue();        // delete and return item from the front
    T peek();           // return (but do not delete) item from the front
    // is the buffer empty (fillCount equals zero)?
    default boolean isEmpty() {
        return fillCount() == 0 ? true : false;
    }
    default boolean isFull() {
        return capacity() == fillCount() ? true : false;
    }
}
