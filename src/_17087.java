import java.io.*;
import java.util.*;

public class _17087 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pos = new PriorityQueue<>();

        int N = Integer.parseInt(st.nextToken());

        pos.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            pos.add(Integer.parseInt(st.nextToken()));
        }

        int start = pos.poll();
        int result = pos.poll() - start;
        while(!pos.isEmpty()){
            int p = pos.poll() - start;
            result = uclid(result, p);
        }
        System.out.println(result);
    }
    private static int uclid(int a, int b){
        return b>0 ? uclid(b, a%b) : a;
    }
}
