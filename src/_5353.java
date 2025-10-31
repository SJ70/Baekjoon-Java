import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _5353 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            for (int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                pq.add(new int[]{from, to});
            }
            int time = 0;
            int result = 0;
            while (!pq.isEmpty()) {
                int from = pq.peek()[0];
                int to = pq.poll()[1];
                if (time <= from) {
                    result++;
                    time = to;
                }
            }
            sb.append(result);
            sb.append('\n');
        }
        System.out.print(sb);
    }

}
