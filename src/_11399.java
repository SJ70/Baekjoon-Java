import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _11399 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) pq.add(Integer.parseInt(st.nextToken()));

        int result = 0;
        int tmp = 0;
        while(!pq.isEmpty()){
            tmp += pq.poll();
            result += tmp;
        }
        System.out.println(result);
    }
}
