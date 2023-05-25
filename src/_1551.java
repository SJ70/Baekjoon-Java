import java.io.*;
import java.util.*;

public class _1551 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(),",");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int k=0; k<K; k++){
            for(int i=0; i+1<N-k; i++){
                arr[i] = arr[i+1] - arr[i];
            }
        }

        StringBuilder sb = new StringBuilder().append(arr[0]);
        for(int i=1; i+K<N; i++){
            sb.append(',').append(arr[i]);
        }
        System.out.println(sb);
    }
}
