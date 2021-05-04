/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {

    public static void main(String[] args) {
        int minLength = 4;
        //String path = "/Users/yangzuliang/Documents/class/cs61b-2018/library-sp18-master/data/words.txt";
        String path = "../library-sp18/data/words.txt";
        In in = new In(path);
        Palindrome palindrome = new Palindrome();

        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word)) {
                System.out.println(word);
            }
        }
    }
    //Uncomment this class once you've written isPalindrome.
}
