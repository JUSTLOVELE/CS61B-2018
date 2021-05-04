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
        //不检查中间字符串的相等性
        boolean odd = (word.length() % 2 != 0) ? true : false;
        Integer noCheckIndex = (word.length() - 1) / 2;

        for (int i = 0; i < word.length(); i++) {

            char x = deque.removeLast();
            char y = chars[i];

            if (odd && i == noCheckIndex) {
                continue;
            }

            boolean b = cc.equalChars(x, y);

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
