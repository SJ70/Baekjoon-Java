import java.io.*;
import java.util.*;

public class _13866 {
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<4; i++){
            pq.add(Integer.parseInt(st.nextToken()));
        }

        int result = pq.poll() - pq.poll() - pq.poll() + pq.poll();
        System.out.println(Math.abs(result));
    }
}
