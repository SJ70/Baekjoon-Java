import java.util.*;
import java.io.*;

public class _17143 {
    public static void main(String[] args) throws IOException{
        Init();
        for(int c=0; c<C; c++){
            CatchShark(c);
            MoveShark();
            //PrintMap();
        }
        System.out.println(Result);
    }
    public static void Init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Map = new int[R][C];
        M = Integer.parseInt(st.nextToken());
        S = new Shark[M+1];
        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            // 속도가 너무 높을 경우 시간 초과 가능성
            if(d==1||d==2) s%=((R-1)*2);
            else s%=((C-1)*2);
            int z = Integer.parseInt(st.nextToken());
            S[i] = new Shark(r,c,s,d,z);
            Map[r][c] = i;
        }
    }
    static int R,C, M;
    static int[][] Map;
    static Shark[] S;
    public static class Shark{
        int r, c, speed, dir, size;
        boolean alive = true;
        public Shark(int r, int c, int s, int d, int z){
            this.r=r; this.c=c; speed=s; dir=d; size=z;
        }
    }
    static int[][] Dir = {{0,0},{-1,0},{1,0},{0,1},{0,-1}};
    public static void PrintMap(){
        char[] Arrow = {' ','↑','↓','→','←'};
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                int N = Map[r][c];
                if(N!=0)
                    System.out.printf("[%d]%d%c%d ",N,S[N].speed,Arrow[S[N].dir],S[N].size);
                else
                    System.out.print("[    ] ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void MoveShark(){
        for(int i=1; i<=M; i++){
            if(!S[i].alive) continue;
            Map[S[i].r][S[i].c] = 0;
            S[i].r += Dir[S[i].dir][0] * S[i].speed;
            S[i].c += Dir[S[i].dir][1] * S[i].speed;
            while( S[i].r < 0 || S[i].r > R-1 || S[i].c < 0 || S[i].c > C-1 ){
                if( S[i].r < 0 ){
                    S[i].r *= -1;
                    S[i].dir = 2;
                }
                else if( S[i].r > R-1 ){
                    S[i].r = (R-1)+((R-1)-S[i].r);
                    S[i].dir = 1;
                }
                else if( S[i].c < 0 ){
                    S[i].c *= -1;
                    S[i].dir = 3;
                }
                else if( S[i].c > C-1 ){
                    S[i].c = (C-1)+((C-1)-S[i].c);
                    S[i].dir = 4;
                }
            }
        }
        // 움직임과 동시에 적용하면 아직 움직이지 않은 상어에게 영향이 갈 수 있으므로 모두 계산 후 적용
        for(int i=1; i<=M; i++){
            if(!S[i].alive) continue;
            // 자리가 빈 경우 그 자리에 넣고
            if(Map[S[i].r][S[i].c]==0){
                Map[S[i].r][S[i].c] = i;
            }
            // 이미 그 자리에 상어가 있는 경우엔 무게를 비교해서 하나 제거
            else if(S[Map[S[i].r][S[i].c]].size < S[i].size){
                S[Map[S[i].r][S[i].c]].alive = false;
                Map[S[i].r][S[i].c] = i;
            }
            else{
                S[i].alive = false;
            }
        }
    }
    static int Result = 0;
    public static void CatchShark(int c){
        for(int r=0; r<R; r++){
            if(Map[r][c]!=0){
                Result += S[Map[r][c]].size;
                S[Map[r][c]].alive = false;
                Map[r][c]=0;
                return;
            }
        }
    }
}
