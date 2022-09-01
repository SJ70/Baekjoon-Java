import java.util.*;
import java.io.*;

public class _1987 {
    public static void main(String[] args) throws IOException{
        Init();
        visited[Map[0][0]-'A']=true;
        Solve(0,0,1);
        System.out.println(Max_Result);
    }
    static int R,C;
    static char[][] Map;
    static boolean[] visited = new boolean[26];
    static int Max_Result = -1;
    public static void Init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Map = new char[R][C];
        for(int r=0; r<R; r++){
            String str = br.readLine();
            for(int c=0; c<C; c++){
                Map[r][c] = str.charAt(c);
            }
        }
    }
    public static void Solve(int r, int c, int cnt){
        if(cnt>Max_Result)
            Max_Result = cnt;
        Visit(r-1,c,cnt);
        Visit(r+1,c,cnt);
        Visit(r,c-1,cnt);
        Visit(r,c+1,cnt);
    }
    public static void Visit(int r, int c, int cnt){
        if( r<0 || r>=R || c<0 || c>=C || visited[Map[r][c]-'A'] ) return;
        visited[Map[r][c]-'A']=true;
        Solve(r,c,cnt+1);
        visited[Map[r][c]-'A']=false;
    }
}