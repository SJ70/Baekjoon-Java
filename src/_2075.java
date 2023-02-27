import java.io.*;
import java.util.*;

public class _2075 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int r=0; r<N; r++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                pq.add(Integer.parseInt(st.nextToken()));
            }
        }
        for(int i=1; i<N; i++){
            pq.poll();
        }
        System.out.println(pq.poll());
    }
}
