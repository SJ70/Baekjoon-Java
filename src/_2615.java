import java.io.*;
import java.util.*;

public class _2615 {
    static final int N = 19;
    static int[][] arr = new int[N][N];
    static boolean[][][] visited = new boolean[N][N][4]; // [row][column][dir]
    static int[] result = new int[3]; // {winner,row,column}
    public static void main(String[] args) throws IOException{
        input();
        for(int c=0; c<N; c++){
            for(int r=0; r<N; r++){
                for(int d=0; d<4; d++){
                    try {
                        if(arr[r][c]!=0 && !visited[r][c][d]){
                            result = new int[]{arr[r][c],r+1,c+1};
                            visit(r,c,d,1);
                        }
                    }
                    catch(Exception e){
                        System.out.printf("%d\n%d %d",result[0],result[1],result[2]);
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }
    public static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int r=0; r<N; r++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }
    }
    static int[] dr = new int[]{0,1,1,-1}; // - | \ /
    static int[] dc = new int[]{1,0,1,1};
    public static void visit(int r, int c, int d, int cnt) throws Exception{
        visited[r][c][d] = true;
        int nextR = r+dr[d];
        int nextC = c+dc[d];
        if(nextR<N && nextC<N && nextR>=0 && !visited[nextR][nextC][d] && arr[r][c]==arr[nextR][nextC]){
            visit(nextR,nextC,d,cnt+1);
        }
        else{
            if(cnt==5) throw new Exception();
        }
    }
}
