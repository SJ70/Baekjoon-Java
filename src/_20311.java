import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _20311 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] counts = new int[N + 1];
        for (int i=1; i<=K; i++) {
            counts[i] = Integer.parseInt(st.nextToken());
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> counts[b] - counts[a]);
        for (int i=1; i<=K; i++) {
            pq.add(i);
        }

        StringBuilder sb = new StringBuilder();
        int prev = -1;
        for (int i=0; i<N; i++) {
            int num = pq.poll();

            if (prev == num) {
                if (pq.isEmpty()) {
                    System.out.println(-1);
                    return;
                }
                // 2등 사용
                int secondNum = pq.poll();
                pq.add(num);
                num = secondNum;
            }
            prev = num;

            counts[num]--;
            if (counts[num] > 0) {
                pq.add(num);
            }

            sb.append(num);
            if (i < N-1) {
                sb.append(" ");
            }
        }

        System.out.println(sb);
    }

}
