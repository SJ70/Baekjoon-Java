import java.io.*;
import java.util.*;

public class _11728 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] B = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        int a = 0;
        int b = 0;
        while(a<N && b<M){
            if(A[a]<B[b]){
                sb.append(A[a]).append(' ');
                a++;
            }
            else{
                sb.append(B[b]).append(' ');
                b++;
            }
        }
        for(; a<N; a++){
            sb.append(A[a]).append(' ');
        }
        for(; b<M; b++){
            sb.append(B[b]).append(' ');
        }

        System.out.println(sb);
    }
}
