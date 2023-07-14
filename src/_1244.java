import java.io.*;
import java.util.*;

public class _1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        boolean[] arr = new boolean[N];
        for(int i=0; i<N; i++){
            arr[i] = st.nextToken().charAt(0)=='1';
        }

        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            boolean boy = Integer.parseInt(st.nextToken()) == 1;
            int num = Integer.parseInt(st.nextToken());
            if(boy){
                for(int j=num; j<=N; j+=num){
                    arr[j-1] = !arr[j-1];
                }
            } else{
                int index = num-1;
                arr[index] = !arr[index];
                int left = index-1;
                int right = index+1;
                while(left>=0 && right<N && arr[left]==arr[right]){
                    arr[left] = arr[right] = !arr[left];
                    left--;
                    right++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            sb.append(arr[i] ? 1 : 0);
            sb.append((((i+1)%20==0 && (i+1)/20>0) || i==N-1) ? '\n' : ' ');
        }
        System.out.print(sb);
    }
}
