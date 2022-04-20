import java.io.*;
import java.util.StringTokenizer;

public class _16395 {
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int M = n-k+1;
        int N = k;
        // 파스칼 삼각형을 60도 돌린 사각형 배열 (평행사변형)
        int[][] P = new int[M][N];
        for(int i=0; i<M; i++)
            P[i][0]=1;
        for(int i=0; i<N; i++)
            P[0][i]=1;
        for(int i=1; i<M; i++)
            for(int j=1; j<N; j++)
                P[i][j] = P[i][j-1] + P[i-1][j];
        System.out.println(P[M-1][N-1]);
    }
}
