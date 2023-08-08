import java.io.*;
import java.util.*;

public class _28417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            result = Math.max(result, getScore(new StringTokenizer(br.readLine())));
        }
        System.out.println(result);
    }
    private static int getScore(StringTokenizer st){
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int Run = Math.max(a,b);

        PriorityQueue<Integer> tricks = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<5; i++){
            tricks.add(Integer.parseInt(st.nextToken()));
        }

        int Trick = tricks.poll() + tricks.poll();

        return Run + Trick;
    }
}
