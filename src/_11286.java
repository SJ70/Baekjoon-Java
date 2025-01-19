import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class _11286 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (Math.abs(a) == Math.abs(b)) {
                return a - b;
            }
            return Math.abs(a) - Math.abs(b);
        });
        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                System.out.println(pq.isEmpty() ? 0 : pq.poll());
            }
            else {
                pq.add(n);
            }
        }
    }

}
