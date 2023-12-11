import java.io.*;
import java.util.*;

public class _11279 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            int value = Integer.parseInt(br.readLine());
            if (value == 0) {
                sb.append(pq.isEmpty() ? 0 : pq.poll()).append('\n');
            }
            else {
                pq.add(value);
            }
        }
        System.out.print(sb);
    }

}
