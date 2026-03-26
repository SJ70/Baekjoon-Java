import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class _28066 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i=1; i<=N; i++) {
            deque.addLast(i);
        }

        while (true) {
            if (deque.size() < K) {
                System.out.println(deque.pollFirst());
                return;
            }
            deque.addLast(deque.pollFirst());
            for (int i=1; i<K; i++) {
                deque.pollFirst();
            }
        }
    }

}
