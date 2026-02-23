import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _34540 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<long[]> arr = new ArrayList<>();
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            long[] location = new long[2];
            location[0] = Long.parseLong(st.nextToken());
            location[1] = Long.parseLong(st.nextToken());
            arr.add(location);
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        char dir = st.nextToken().charAt(0);

        PriorityQueue<long[]> pq = new PriorityQueue<>(
                (a, b) -> (dir == 'E')
                            ? (a[0] == b[0])
                                    ? Long.compare(a[1], b[1])
                                    : Long.compare(a[0], b[0])
                            : (a[1] == b[1])
                                    ? Long.compare(a[0], b[0])
                                    : Long.compare(a[1], b[1])
        );
        pq.addAll(arr);

        long result = 0;
        while (!pq.isEmpty()) {
            long[] location = pq.poll();
            result += Math.abs(location[0] - x) + Math.abs(location[1] - y);
            if (dir == 'E') {
                x++;
            } else {
                y++;
            }
        }
        System.out.println(result);

    }

}
