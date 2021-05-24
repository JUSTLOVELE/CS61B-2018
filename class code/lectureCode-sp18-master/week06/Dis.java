import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Dis {

    public static void topFivePopularWords(String[] words, int k) {

        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            if (!counts.containsKey(word)) {
                counts.put(word, 1);
            } else {
                counts.put(word, counts.get(word) + 1);
            }
        }

        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return counts.get(o2) - counts.get(a);
            }
        });

        for (String word : counts.keySet()) {
            pq.add(word);
        }

        for (int i = 0; i < k; i++) {
            System.out.println(pq.poll());
        }
    }

    public boolean twoSum(int[] A, int k) {

        Set<Integer> prevSeen = new HashSet<>();

        for (int i : A) {

            if (prevSeen.contains(k - i)) {
                return true;
            }

            prevSeen.add(i);
        }

        return false;
    }

}
