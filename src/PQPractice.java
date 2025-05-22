import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PQPractice {

    private record GraphicMemoir(String name, int interest) implements Comparable<GraphicMemoir> {
        @Override
        public int compareTo(GraphicMemoir other) {
            return Integer.compare(this.interest, other.interest);
        }
    }

    public static void main(String[] args) {
        
        // PriorityQueue<Integer> pq = new PriorityQueue<>();

        // pq.add(7);
        // pq.add(33);
        // pq.add(2);
        // pq.add(99);
        // pq.poll();
        // pq.poll();

        // System.out.println();
        // System.out.println(pq.peek());
        // System.out.println(pq.poll());

        PriorityQueue<GraphicMemoir> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(new GraphicMemoir("I'm a Wild Seed", 62));
        pq.add(new GraphicMemoir("The Third Person", 83));
        pq.add(new GraphicMemoir("Calling Dr. Laura", 55));
        pq.add(new GraphicMemoir("The Bride was a Boy", 100));

        System.out.println(pq.poll());

        List<Integer> nums = List.of(22, 33, 452, 1, 46, 0, 333, 234);
        System.out.println(topK(nums, 3));
        System.out.println(topKEfficient(nums, 3));
        
    }

    // return top K elements in the list (if k = 5, return 10 biggest numbers in list)
    // the original list is not modified
    public static List<Integer> topK(List<Integer> nums, int k) {
        List<Integer> copy = new ArrayList<>(nums);
        Collections.sort(copy);
        return copy.subList(nums.size() - k, nums.size());
    }

        public static List<Integer> topKEfficient(List<Integer> nums, int k) {
        // Make a PQ
        // For nums, while nums is less than k items long, add to PQ
        PriorityQueue<Integer> best = new PriorityQueue<>();

        for (int num: nums) {
            if (best.size() < k) {
                best.add(num);
            } else if (num > best.peek()) {
                best.poll();
                best.add(num);
            }
        }

        List<Integer> list = new ArrayList<>();

        while (!best.isEmpty()) {
            list.add(best.poll());
        }

        return list;
    }
}