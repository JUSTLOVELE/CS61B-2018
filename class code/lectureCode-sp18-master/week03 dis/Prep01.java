import java.util.Arrays;

public class Prep01 {
    public static void main(String[] args) {

        int[] a = flatten(new int[][] { { 1, 2, 3 }, {}, { 7, 8 } });
        System.out.println(Arrays.toString(a));
    }

    // For example, flatten({{1, 2, 3}, {}, {7, 8}}) should return {1, 2, 3, 7, 8}.
    public static int[] flatten(int[][] x) {
        int totalLength = 0;

        for (int i = 0; i < x.length; i++) {
            totalLength += x[i].length;
        }

        int[] a = new int[totalLength];
        int aIndex = 0;

        for (int i = 0; i < x.length; i++) {

            for (int j = 0; j < x[i].length; j++) {

                a[aIndex] = x[i][j];
                aIndex++;
            }
        }

        return a;
    }
}
