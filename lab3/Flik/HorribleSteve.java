public class HorribleSteve {
    public static void main(String [] args) {
//        Integer k = 128;
//        Integer n = 128;
//        System.out.println(k == n);
        int i = 0;
        for (int j = 0; i < 500; ++i, ++j) {
            //System.out.println(i + "," + j);
            if (!Flik.isSameNumber(i, j)) {
                break; // break exits the for loop!
            }
        }
        System.out.println("i is " + i);
    }
}