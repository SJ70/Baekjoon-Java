import java.io.*;
import java.util.*;

public class _28236 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int minIndex = 1;
        int minValue = Integer.MAX_VALUE;
        for(int k=1; k<=K; k++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int value = n + M-m;
            if(value < minValue){
                minValue = value;
                minIndex = k;
            }
        }

        System.out.println(minIndex);
    }
}
