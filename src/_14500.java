import java.io.*;
import java.util.*;

public class _14500 {
    static int N,M;
    static int[][] Map;
    static boolean[][] Visited; // 이미 모든 경우의 수를 테스트한 좌표는 재방문할 필요 X
    public static void main(String[] args) throws IOException {
        Input();
        for(int r=0; r<N; r++)
            for(int c=0; c<M; c++){
                MakeT(new Tetromino(r,c));
                Visited[r][c] = true;
                CheckMore(r,c);
            }
        System.out.println(Max);
    }
    public static void Input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Map = new int[N][M];
        Visited = new boolean[N][M];
        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<M; c++)
                Map[r][c] = Integer.parseInt(st.nextToken());
        }
    }
    static class Tetromino{
        int[] r = new int[4];
        int[] c = new int[4];
        int cnt;
        public Tetromino(int r, int c){
            this.r[0]=r;
            this.c[0]=c;
            this.cnt = 1;
        }
        public Tetromino(Tetromino t, int r, int c){
            for(int i=0; i<t.cnt; i++){
                this.r[i]=t.r[i];
                this.c[i]=t.c[i];
            }
            this.r[t.cnt]=r;
            this.c[t.cnt]=c;
            this.cnt = t.cnt+1;
        }
    }
    static int Max = 0;
    public static void MakeT(Tetromino t){
        if(t.cnt<4){
            int r = t.r[t.cnt-1];
            int c = t.c[t.cnt-1];
            CheckAndMakeT(t,r-1,c);
            CheckAndMakeT(t,r+1,c);
            CheckAndMakeT(t,r,c-1);
            CheckAndMakeT(t,r,c+1);
        }
        else{ // t.cnt==4
            int tmp=0;
            for(int i=0; i<4; i++)
                tmp += Map[t.r[i]][t.c[i]];
            // if(Max<tmp) System.out.println(Arrays.toString(t.r)+Arrays.toString(t.c)+tmp);
            Max = Math.max(Max,tmp);
        }
    }
    public static void CheckAndMakeT(Tetromino t, int r, int c){
        for(int i=0; i<t.cnt-1; i++)
            if( t.r[i]==r && t.c[i]==c ) return; // 중복 배제
        if( r>=0 && r<N && c>=0 && c<M && !Visited[r][c])
            MakeT(new Tetromino(t,r,c));
    }
    // 이상의 코드는 T,r,s 모양을 확인하지 못함
    public static void CheckMore(int r, int c){
        Max = Math.max(Max,TU(r,c));
        Max = Math.max(Max,TD(r,c));
        Max = Math.max(Max,TL(r,c));
        Max = Math.max(Max,TR(r,c));
        Max = Math.max(Max,r1(r,c));
        Max = Math.max(Max,r2(r,c));
        Max = Math.max(Max,s(r,c));
    }
    public static int TU(int r, int c){
        if( c-1>=0 && c+1<M && r-1>=0 )
        return Map[r][c-1]+Map[r][c]+Map[r][c+1]+Map[r-1][c];
        else return -1;
    }
    public static int TD(int r, int c){
        if( c-1>=0 && c+1<M && r+1<N )
        return Map[r][c-1]+Map[r][c]+Map[r][c+1]+Map[r+1][c];
        else return -1;
    }
    public static int TL(int r, int c){
        if( r-1>=0 && r+1<N && c-1>=0 )
        return Map[r-1][c]+Map[r][c]+Map[r+1][c]+Map[r][c-1];
        else return -1;
    }
    public static int TR(int r, int c){
        if( r-1>=0 && r+1<N && c+1<M )
        return Map[r-1][c]+Map[r][c]+Map[r+1][c]+Map[r][c+1];
        else return -1;
    }
    public static int r1(int r, int c){
        if( r+1<N && c+2<M )
            return Map[r][c]+Map[r+1][c]+Map[r][c+1]+Map[r][c+2];
        else return -1;
    }
    public static int r2(int r, int c){
        if( r+2<N && c+1<M )
            return Map[r][c]+Map[r+1][c]+Map[r+2][c]+Map[r][c+1];
        else return -1;
    }
    public static int s(int r, int c){
        if( c-1>=0 && r+1<N && c+1<M )
            return Map[r][c]+Map[r+1][c]+Map[r+1][c-1]+Map[r][c+1];
        else return -1;
    }
}