import java.io.*;
import java.util.*;

public class _28282 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] left = new int[K];
        for(int i=0; i<X; i++){
            left[Integer.parseInt(st.nextToken())-1]++;
        }
        int[] right = new int[K];
        for(int i=0; i<X; i++){
            right[Integer.parseInt(st.nextToken())-1]++;
        }

        long result = 0;
        for(int i=0; i<K; i++){
            result += (long)left[i] * (long)(X - right[i]);
        }

        System.out.println(result);
    }
}
