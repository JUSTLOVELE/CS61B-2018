package synthesizer;
// package <package name>;

import java.util.Iterator;

public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {

        first = 0;
        last = 0;
        fillCount = 0;
        //       this.capacity should be set appropriately. Note that the local variable
        this.capacity = capacity;
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
        rb = (T[]) new Object[capacity];
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {

        if (fillCount() == capacity()) {
            throw new RuntimeException("Ring buffer overflow");
        }

        this.rb[last] = x;
        fillCount++;

        if (last == this.rb.length - 1) {
            //到达数组的边缘
            this.last = 0;
        } else {
            last++;
        }
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {

        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }

        T t = this.rb[first];
        this.rb[first] = null;
        this.fillCount--;

        if (this.first == this.rb.length - 1) {
            this.first = 0; //到达边缘置为0
        } else {
            first++;
        }

        return t;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {

        if (isEmpty()) {
            return null;
        }

        return this.rb[first];
    }

    @Override
    void moveTo(double deltaX, double deltaY) {

    }

    @Override
    public Iterator<T> iterator() {
        return new KeyIterator();
    }

    public class KeyIterator implements Iterator<T> {

        @Override
        public boolean hasNext() {
            return isEmpty() ? false : true;
        }

        @Override
        public T next() {
            return dequeue();
        }
    }
}
