/**
 * 在本练习中，我们强烈建议您将数组视为圆形。
 * 换句话说，如果您的前指针在位置0,并且调用了addFirst，
 * 则前指针应该循环回到数组的末尾(因此双端队列中的新前项将是基础数组中的最后一项)。
 * 这将导致比非循环方法少得多的麻烦。有关更多详细信息，请参见项目1演示幻灯片。
 * 注意：
 * 1、add和remove除了重新规划数组外只要花费常数时间的代价
 * 2、get和size必须是常数时间
 * 3、初始数组长度为8
 * 4、您的程序在任何给定时间使用的内存量必须与项目数量成比例。
 * 例如，如果您向deque添加10，000个项目，然后移除9，999个项目，
 * 您不应该仍然使用长度为10，000左右的数组。对于长度为16或更长的数组，
 * 您的使用系数应始终至少为25%。对于较小的阵列，您的使用系数可以任意低。
 */

public class ArrayDeque<T> {

    private int size = 0;

    private int nextFirst;

    private int nextLast;

    private int item = 0;

    private T[] arrays;
//
//    public static void main(String[] args) {
//
//        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
//        arrayDeque.addFirst("a");
//        arrayDeque.addFirst("b");
//        arrayDeque.addFirst("c");
//        arrayDeque.addFirst("d");
//        arrayDeque.addLast("e");
//        arrayDeque.addLast("f");
//        arrayDeque.addLast("g");
//        arrayDeque.addLast("h");
//        arrayDeque.addLast("k");
//        arrayDeque.addLast("e");
//        arrayDeque.addLast("f");
//        arrayDeque.addLast("g");
//        arrayDeque.addLast("h");
//        arrayDeque.addLast("k");
//        arrayDeque.addLast("e");
//        arrayDeque.addLast("f");
//        arrayDeque.addLast("g");
//        arrayDeque.addLast("h");
//        arrayDeque.addLast("k");
//
//        arrayDeque.removeFirst();
//        arrayDeque.removeFirst();
//        arrayDeque.removeLast();
//        arrayDeque.removeFirst();
//        arrayDeque.removeFirst();
//        arrayDeque.removeLast();
//        arrayDeque.removeFirst();
//        arrayDeque.removeFirst();
//        arrayDeque.removeLast();
//        arrayDeque.removeFirst();
//        arrayDeque.removeFirst();
//        arrayDeque.removeLast();
//
//        arrayDeque.printDeque();
//    }

    /**
     * Creates an empty linked list deque.
     */
    public ArrayDeque() {
        arrays = (T[]) new Object[8];
        //初始化nextFirst、nextLast
        this.nextFirst = item + 1;
        this.nextLast = item + 2;
    }

    /**
     * Adds an item of type T to the front of the deque
     * @param t
     */
    public void addFirst(T t) {
        //要考虑nextFirst-1和nextLast重合,然后就要resize数组
        //注意nextFirst和nextLast都是空位
        //两个相邻的情况和first在头,last在尾的情况都是要扩展的
        if (this.size == this.arrays.length - 2) {
            //重新规划数组
            resizeWithIncrease();
        }
        //要考虑nextFrist-1数组越界要插入到数组边界
        this.arrays[this.nextFirst] = t;

        if (this.nextFirst == 0) {
            this.nextFirst = this.arrays.length - 1;
        } else {
            this.nextFirst--;
        }

        size++;
    }

    /**
     * Adds an item of type T to the back of the deque
     * @param t
     */
    public void addLast(T t) {
        //要考虑nextFirst和nextLast+1重合,然后就要resize数组
        //注意nextFirst和nextLast都是空位
        //两个相邻的情况和first在头,last在尾的情况都是要扩展的
        if (this.size == this.arrays.length - 2) {
            //重新规划数组
            resizeWithIncrease();
        }
        //要考虑nextLast+1数组越界要插入到数组边界
        this.arrays[this.nextLast] = t;

        if (this.nextLast == this.arrays.length - 1) {
            this.nextLast = 0;
        } else {
            this.nextLast++;
        }

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

        boolean flag = true;
        int first = this.nextFirst + 1;
        int last = this.nextLast;

        while (flag) {

            System.out.print(this.arrays[first]);
            first++;

            if (first > this.arrays.length - 1) {
                first = 0;
            }

            if (first == last) {
                flag = false;
            }
        }

        System.out.println();
    }


    private void resizeWithIncrease() {
        //从nextFirst->nextLast
        T[] newArray = (T[]) new Object[this.arrays.length * 2];
        boolean flag = true;
        int index = 0;

        while (flag) {
            //节点相邻
            if (this.nextFirst != this.nextLast) {
                //这里还有个特殊情况,就是nextFirst在尾部节点,
                if (this.nextFirst == this.arrays.length - 1) {
                    //如果nextFirst走到了数组右边的边界,就置于0,置于0就相当于+1,所以这里就不加一了
                    this.nextFirst = 0;
                } else {
                    //因为nextFirst是空位,所以要+1才有值的
                    this.nextFirst++;
                }
                //先+1是因为0位留给nextFirst,因为nextFirst要是空位
                index++;
                newArray[index] = this.arrays[this.nextFirst];
            } else {
                flag = false;
            }
        }

        this.nextFirst = 0;
        this.nextLast = index++; //最后再加一是因为nextLast要是空的
        this.arrays = newArray;
    }

    private void resizeIDecrease() {

        if (this.arrays.length < 16) {
            return;
        }

        if (size * 2 > this.arrays.length) {
            return;
        }
        //空置率至少一半,缩小25%
        int length = Double.valueOf(this.arrays.length * 0.75).intValue();
        T[] newArray = (T[]) new Object[length];

        boolean flag = true;
        int index = 0;

        while (flag) {
            //为什么加一呢?因为nextFirst和nextLast是空的,加一如果相等意味着不能再往前了
            if (this.nextFirst != this.nextLast) {

                if (this.nextFirst >= this.arrays.length) {
                    //如果nextFirst走到了数组右边的边界,就置于0
                    this.nextFirst = 0;
                } else {
                    this.nextFirst++;
                }
                //先+1是因为0位留给nextFirst,因为nextFirst要是空位
                index++;
                newArray[index] = this.arrays[this.nextFirst];

            } else {
                flag = false;
            }
        }

        this.nextFirst = 0;
        this.nextLast = index + 1; //最后再加一是因为nextLast要是空的
        this.arrays = newArray;

    }

    /**
     * Removes and returns the item at the front of the deque. If no such item exists, returns null.
     * @return
     */
    public T removeFirst() {

        if (isEmpty()) {
            return null;
        }

        T t = this.arrays[this.nextFirst + 1];
        this.arrays[this.nextFirst + 1] = null;
        size--;

        if (this.nextFirst == this.arrays.length - 1) {
            this.nextFirst = 0;
        } else {
            this.nextFirst++;
        }

        resizeIDecrease();

        return t;
    }

    /**
     * Removes and returns the item at the back of the deque. If no such item exists, returns null.
     * @return
     */
    public T removeLast() {

        if (isEmpty()) {
            return null;
        }

        T t = this.arrays[this.nextLast - 1];
        this.arrays[this.nextLast - 1] = null;
        size--;

        if (this.nextLast == 0) {
            this.nextLast = this.arrays.length - 1;
        } else {
            this.nextLast--;
        }

        resizeIDecrease();

        return t;
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

        return this.arrays[index];
    }
}
