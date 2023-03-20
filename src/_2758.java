import java.io.*;
import java.util.*;

public class _2758 {
    static int N = 10;
    static int M = 2000;
    static long[][] Arr = new long[N+1][M+1];
    public static void main(String[] args) throws IOException {
        DP();
        PrefixSum();
        Solve();
    }
    public static void DP(){
        for(int m=1; m<=M; m++){
            Arr[1][m] = 1;
        }
        for(int m=1; m<=M; m++){
            for(int k=m*2; k<=M; k++){
                for(int n=1; n<N; n++){
                    Arr[n+1][k] += Arr[n][m];
                }
            }
        }
    }
    public static void PrefixSum(){
        for(int m=2; m<=M; m++){
            for(int n=1; n<=N; n++){
                Arr[n][m] += Arr[n][m-1];
            }
        }
    }
    public static void Solve() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb.append(Arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]).append('\n');
        }
        System.out.print(sb);
    }
}
