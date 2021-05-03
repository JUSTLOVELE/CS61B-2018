import java.util.Arrays;

public class ALArrays {

    public static void main(String[] args) {

        int[] x = new int[] { 5, 9, 14, 15 };
        x = insert(x, 6, 2);
        System.out.println(Arrays.toString(x));
        reverse(x);
        System.out.println(Arrays.toString(x));
        // x = new int[] { 3, 2, 1 };
        x = replicate(x);
        System.out.println(Arrays.toString(x));
    }

    /**
     * For example, if x = [5, 9, 14, 15], item = 6, and position = 2, then the
     * method should return [5, 9, 6, 14, 15].
     * 
     * @param arr
     * @param item
     * @param position
     * @return
     */
    public static int[] insert(int[] arr, int item, int position) {
        // 答案实现
        int[] result = new int[arr.length + 1];
        position = Math.min(arr.length, position);

        for (int i = 0; i < position; i++) {
            result[i] = arr[i];
        }

        result[position] = item;
        for (int i = position; i < arr.length; i++) {
            result[i + 1] = arr[i];
        }

        return result;
        // 我的实现
        // int[] newArr = new int[arr.length + 1];
        // int index = 0;

        // for (int i = 0; i < arr.length; i++) {

        // if (i == position) {
        // newArr[i] = item;
        // index++;
        // }

        // newArr[index] = arr[i];
        // index++;
        // }

        // return newArr;
    }

    public static void reverse(int[] arr) {
        // 答案实现,中间值不变,然后交换首尾
        for (int i = 0; i < arr.length / 2; i++) {
            int j = arr.length - i - 1;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        // 我的实现
        // int[] r = new int[arr.length];
        // int index = arr.length - 1;

        // for (int a : arr) {

        // r[index] = a;
        // index--;
        // }

        // for (int i = 0; i < arr.length; i++) {
        // arr[i] = r[i];
        // }
    }

    /**
     * Write a non-destructive method replicate(int[] arr) that replaces the number
     * at index i with arr[i] copies of itself. For example, replicate([3, 2, 1])
     * would return [3, 3, 3, 2, 2, 1].
     * 
     * @param arr
     * @return
     */
    public static int[] replicate(int[] arr) {

        int sum = 0;

        for (int s : arr) {
            sum += s;
        }

        int[] a = new int[sum];
        int index = 0;

        for (int i = 0; i < arr.length; i++) {

            int value = arr[i];

            for (int j = 0; j < value; j++) {
                a[index] = value;
                index++;
            }
        }

        return a;
    }
}