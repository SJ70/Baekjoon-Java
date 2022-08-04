import java.util.*;
import java.io.*;

public class _2178 {
    static int R,C;
    static int[][] Map;
    static boolean[][] Visited;
    public static void Input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Map = new int[R][C];
        Visited = new boolean[R][C];
        for(int r=0; r<R; r++){
            String str = br.readLine();
            for(int c=0; c<C; c++){
                Map[r][c] = str.charAt(c)-'0';
            }
        }
    }
    public static void main(String[] args) throws IOException{
        Input();
        AddQ(0,0,1);
        while(!pos.isEmpty()){
            int r = pos.poll();
            int c = pos.poll();
            int time = pos.poll();
            if(r==R-1 && c==C-1){
                System.out.println(time);
                return;
            }
            AddQ(r+1,c,time+1);
            AddQ(r-1,c,time+1);
            AddQ(r,c+1,time+1);
            AddQ(r,c-1,time+1);
        }
    }
    static Queue<Integer> pos = new ArrayDeque<>();
    public static void AddQ(int r, int c, int time){
        if( r<0 || r>=R || c<0 || c>=C || Map[r][c]==0 || Visited[r][c] ) return;
        pos.add(r);
        pos.add(c);
        pos.add(time);
        Visited[r][c]=true;
    }
}