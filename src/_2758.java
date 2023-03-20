import java.io.*;
import java.util.*;

public class _2758 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb.append(solve(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))).append('\n');
        }
        System.out.print(sb);
    }
    public static long solve(int N, int M){
        long[][] arr = new long[N+1][M+1];
        for(int m=1; m<=M; m++){
            arr[1][m] = 1;
        }
        for(int m=1; m<=M; m++){
            for(int k=m*2; k<=M; k++){
                for(int n=1; n<N; n++){
                    arr[n+1][k] += arr[n][m];
                }
            }
        }
        long result = 0L;
        for(int m=1; m<=M; m++){
            result += arr[N][m];
        }
        return result;
    }
}
