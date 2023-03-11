import java.io.*;
import java.util.StringTokenizer;

public class _10811 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = i+1;
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken()) -1;
            int r = Integer.parseInt(st.nextToken()) -1;

            while(l<r){
                int tmp = arr[l];
                arr[l] = arr[r];
                arr[r] = tmp;
                l++;
                r--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int e : arr){
            sb.append(e).append(' ');
        }
        System.out.println(sb);
    }
}
