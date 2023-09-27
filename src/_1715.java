import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class _1715 {

    private final static PriorityQueue<Integer> entireDequeSize = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        input();

        long result = 0L;
        while (entireDequeSize.size() > 1) {
            int smallestDequeSize = entireDequeSize.poll();
            int nextSmallestDequeSize = entireDequeSize.poll();
            int newDequeSize = smallestDequeSize + nextSmallestDequeSize;
            entireDequeSize.add(newDequeSize);
            result += newDequeSize;
        }

        System.out.println(result);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            int dequeSize = Integer.parseInt(br.readLine());
            entireDequeSize.add(dequeSize);
        }
    }
}
