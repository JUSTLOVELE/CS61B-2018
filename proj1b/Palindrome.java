public class Palindrome {

    /**
     * 回文,意思就是正着读和反着读是一样的
     * @param word
     * @param cc
     * @return
     */
    public boolean isPalindrome(String word, CharacterComparator cc) {

        if (word == null || word.length() <= 1) {
            return true;
        }

        Deque<Character> deque = wordToDeque(word);
        char[] chars = word.toCharArray();

        for (int i = 0; i < word.length(); i++) {

            boolean b = cc.equalChars(deque.removeLast(), chars[i]);

            if (!b) {
                return false;
            }
        }

        return true;
    }


    /**
     * 回文,意思就是正着读和反着读是一样的
     * @param word
     * @return
     */
    public boolean isPalindrome(String word) {

        if (word == null || word.length() <= 1) {
            return true;
        }

        Deque<Character> deque = wordToDeque(word);

        String actual = "";
        for (int i = 0; i < word.length(); i++) {
            actual += deque.removeLast();
        }

        if (word.equals(actual)) {
            return true;
        }

        return false;
    }

    public Deque<Character> wordToDeque(String word) {

        char[] chars = word.toCharArray();
        Deque<Character> deque = new LinkedListDeque<>();

        for (char c: chars) {
            deque.addLast(c);
        }

        return deque;
    }
}
