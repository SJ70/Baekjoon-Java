import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _25391 {

    private static int N, M, K;

    private static PriorityQueue<int[]> pq1 = new PriorityQueue<>((a, b) -> b[0] - a[0]);
    private static PriorityQueue<int[]> pq2 = new PriorityQueue<>((a, b) -> b[1] - a[1]);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int[] arr = {a, b, 0};
            pq1.add(arr);
            pq2.add(arr);
        }

        long result = 0;
        for (int i=0; i<K; i++) {
            int[] arr = pq2.poll();
            arr[2] = 1;
            result += arr[0];
        }

        for (int i=0; i<M;) {
            int[] arr = pq1.poll();
            if (arr[2] == 0) {
                result += arr[0];
                i++;
            }
        }

        System.out.println(result);

    }

}
