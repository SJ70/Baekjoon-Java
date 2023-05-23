import java.util.*;
import java.io.*;

public class _2399 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        long result = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                result += Math.abs(arr[i]-arr[j]);
            }
        }
        System.out.println(result);
    }
}
