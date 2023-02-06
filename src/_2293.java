import java.io.*;
import java.util.*;

public class _2293 {
    static int N,K;
    static long[] arr;
    public static void main(String[] arg) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new long[K+1];
        arr[0] = 1;

        for(int n=0; n<N; n++){
            long value = Long.parseLong(br.readLine());
            for(long i=value; i<=K; i++){
                arr[(int)i] += arr[(int)(i-value)];
            }
        }

        System.out.println(arr[K]);
    }
}
