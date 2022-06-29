import java.io.*;
import java.util.*;

public class _2206 {
    public static void main(String[] args) throws IOException {
        Input();
        QueueAdd(0,0,1,1);
        while(!success&&!Q.isEmpty())
            BFS(Q.poll(),Q.poll(),Q.poll(),Q.poll());
        System.out.println(Min_time);
    }
    static boolean success;
    static int R,C;
    static boolean[][] wall, visited, Crashed_visited;
    public static void Input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        wall = new boolean[R][C];
        visited = new boolean[R][C];
        Crashed_visited = new boolean[R][C];
        for(int r=0; r<R; r++){
            String str = br.readLine();
            for(int c=0; c<C; c++){
                wall[r][c] = (str.charAt(c)=='1');
            }
        }
    }
    static int Min_time = -1;
    static Queue<Integer> Q = new ArrayDeque<>();
    public static void BFS(int r, int c, int time, int crash){
        if( r==R-1 && c==C-1 ){
            Min_time=time;
            success=true;
            return;
        }
        if( r<0 || r>=R || c<0 || c>=C || visited[r][c] ) return;
        if( crash==0 && Crashed_visited[r][c] ) return;
        if(wall[r][c]){
            if(crash>0) crash--;
            else return;
        }
        if(crash>0) visited[r][c]=true;
        else Crashed_visited[r][c]=true;
        QueueAdd(r-1,c,time+1,crash);
        QueueAdd(r+1,c,time+1,crash);
        QueueAdd(r,c-1,time+1,crash);
        QueueAdd(r,c+1,time+1,crash);
    }
    public static void QueueAdd(int r, int c, int time, int crash){
        Q.add(r);
        Q.add(c);
        Q.add(time);
        Q.add(crash);
    }
}
