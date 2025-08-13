import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _23559 {

    private static int N;
    private static int money;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        money = Integer.parseInt(st.nextToken());

        int n5000max = (money / 1000 - N) / 4;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] - b[1]) - (a[0] - a[1]));

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int[] bob = new int[2];
            bob[0] = Integer.parseInt(st.nextToken());
            bob[1] = Integer.parseInt(st.nextToken());
            pq.add(bob);
        }

        int result = 0;
        while (!pq.isEmpty()) {
            int[] bob = pq.poll();
            if (bob[0] > bob[1] && n5000max >= 1) {
                n5000max--;
                result += bob[0];
            }
            else {
                result += bob[1];
            }
        }

        System.out.println(result);

    }

}
