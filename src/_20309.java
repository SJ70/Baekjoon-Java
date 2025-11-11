import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _20309 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        PriorityQueue<Integer> odd = new PriorityQueue<>((a, b) -> a - b);
        PriorityQueue<Integer> even = new PriorityQueue<>((a, b) -> a - b);
        for (int i=0; i<N; i+=2) {
            odd.add(arr[i]);
        }
        for (int i=1; i<N; i+=2) {
            even.add(arr[i]);
        }

        int[] sorted = new int[N];
        boolean pollFromOdd = true;
        for (int i=0; i<N; i++) {
            sorted[i] = pollFromOdd
                    ? odd.poll()
                    : even.poll();
            pollFromOdd = !pollFromOdd;
        }

        for (int i=0; i<N-1; i++) {
            if (sorted[i] > sorted[i + 1]) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

}
