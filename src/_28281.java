import java.io.*;
import java.util.*;

public class _28281 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] PRICES = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            PRICES[i] = Integer.parseInt(st.nextToken());
        }

        int min_price = Integer.MAX_VALUE;
        for(int i=0; i<N-1; i++){
            min_price = Math.min(min_price, PRICES[i]+PRICES[i+1]);
        }
        int result = min_price * X;
        System.out.println(result);
    }
}
