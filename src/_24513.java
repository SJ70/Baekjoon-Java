import java.util.*;
import java.io.*;

public class _24513 {
    static int N,M;
    static int[][] Map;
    static int[][] time;
    static Queue<Pos> q = new ArrayDeque<>();
    static class Pos{
        int r,c,kind,time;
        public Pos(int r, int c, int kind, int time){
            this.r=r; this.c=c; this.kind=kind; this.time=time;
        }
    }
    public static void main(String[] args) throws IOException{
        Input();
        while(!q.isEmpty()){
            //test_print();
            Infect(q.peek(),0);
            Infect(q.peek(),1);
            Infect(q.peek(),2);
            Infect(q.poll(),3);
        }
        Count();
        System.out.printf("%d %d %d",one,two,three);
    }
    public static void Input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Map = new int[N][M];
        time = new int[N][M];
        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<M; c++){
                int n = Integer.parseInt(st.nextToken());
                Map[r][c] = n;
                if( n==1 || n==2 ) q.add(new Pos(r,c,n,1));
            }
        }
    }
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = { 0, 0,-1, 1};
    public static void Infect(Pos p, int Dir){
        if(Map[p.r][p.c]!=3){ //3으로 변했으면 진행하지 않음
            int next_r = p.r+dr[Dir];
            int next_c = p.c+dc[Dir];
            if( next_r>=0 && next_r<N && next_c>=0 && next_c<M ){
                if( Map[next_r][next_c]==0 ){
                    q.add(new Pos(next_r,next_c,p.kind,p.time+1));
                    Map[next_r][next_c] = p.kind;
                    time[next_r][next_c] = p.time;
                }
                else if(time[next_r][next_c]==p.time){
                    if( (Map[next_r][next_c]==2 && p.kind==1) || (Map[next_r][next_c]==1 && p.kind==2) )
                        Map[next_r][next_c] = 3;
                }
            }
        }
    }
    public static void test_print(){
        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++)
                System.out.printf("%2d",Map[r][c]);
            System.out.println();
        }
        System.out.println();
    }
    static int one,two,three;
    public static void Count(){
        for(int r=0; r<N; r++)
            for(int c=0; c<M; c++)
                switch(Map[r][c]){
                    case 1: one++; break;
                    case 2: two++; break;
                    case 3: three++; break;
                }
    }
}
