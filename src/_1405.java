import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class _1405 {
    static int N;
    static double[] percent;
    static boolean[][] visited;
    static double result = 0;
    public static void main(String[] args) throws IOException{
        init();
        visited[N][N] = true;
        bt(0,N,N,1);
        System.out.print(new BigDecimal(result));
    }
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        percent = new double[4];
        for(int i=0; i<4; i++){
            percent[i] = Double.parseDouble(st.nextToken())/100;
        }
        visited = new boolean[2*N+1][2*N+1];
    }
    static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public static void bt(int cnt, int r, int c, double per){
        if(cnt==N){
            result += per;
            return;
        }

        for(int i=0; i<4; i++){
            if(percent[i]==0) continue;
            int nextR = r+dir[i][0];
            int nextC = c+dir[i][1];
            if(visited[nextR][nextC]) continue;
            visited[nextR][nextC] = true;
            bt(cnt+1, nextR, nextC, per*percent[i]);
            visited[nextR][nextC] = false;
        }
    }
}
