import java.io.*;
import java.util.*;

public class _15683 {
    static int N,M, result=64;
    static ArrayList<Pos> cctv = new ArrayList<>();
    static class Pos{
        int r,c;
        public Pos(int r, int c){
            this.r=r; this.c=c;
        }
    }

    public static void main(String[] args) throws IOException{
        int[][] Map = Input();
        //test_print(Map);
        CCTV(copy(Map),0);
        System.out.println(result);

    }
    public static int[][] Input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] Map = new int[N][M];
        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<M; c++){
                int n = Integer.parseInt(st.nextToken());
                if(n>0 && n<6) cctv.add(new Pos(r,c));
                Map[r][c] = n;
            }
        }
        return Map;
    }
    public static void CCTV(int[][] Map, int Index){
        //System.out.println(result);
        if( Index > cctv.size()-1 ){ // cctv를 모두 확인했으면 종료 /
            result = Math.min(result,CntBlind(Map));
            //test_print(Map);
        }
        else if(result!=0) { // 최솟값이 0이 아닐 때만 연산
            int r = cctv.get(Index).r;
            int c = cctv.get(Index).c;
            switch(Map[r][c]){
                case 1 : { // 상, 하, 좌, 우
                    CCTV(See(copy(Map),r,c,0),Index+1);
                    CCTV(See(copy(Map),r,c,1),Index+1);
                    CCTV(See(copy(Map),r,c,2),Index+1);
                    CCTV(See(copy(Map),r,c,3),Index+1);
                    break;
                }
                case 2 : { // 상하, 좌우
                    CCTV(See(See(copy(Map),r,c,0),r,c,1),Index+1);
                    CCTV(See(See(copy(Map),r,c,2),r,c,3),Index+1);
                    break;
                }
                case 3 : { // 상단좌측, 상단우측, 하단좌측, 하단우측
                    CCTV(See(See(copy(Map),r,c,0),r,c,2),Index+1);
                    CCTV(See(See(copy(Map),r,c,0),r,c,3),Index+1);
                    CCTV(See(See(copy(Map),r,c,1),r,c,2),Index+1);
                    CCTV(See(See(copy(Map),r,c,1),r,c,3),Index+1);
                    break;
                }
                case 4 : { // 상단빼고, 하단빼고, 좌측빼고, 우측빼고
                    CCTV(See(See(See(copy(Map),r,c,0),r,c,1),r,c,2),Index+1);
                    CCTV(See(See(See(copy(Map),r,c,0),r,c,1),r,c,3),Index+1);
                    CCTV(See(See(See(copy(Map),r,c,0),r,c,2),r,c,3),Index+1);
                    CCTV(See(See(See(copy(Map),r,c,1),r,c,2),r,c,3),Index+1);
                    break;
                }
                case 5 : { // 상하좌우
                    CCTV(See(See(See(See(copy(Map),r,c,0),r,c,1),r,c,2),r,c,3),Index+1);
                    break;
                }
            }
        }
    }
    static int[] dr = {-1, 1, 0, 0}; // 상하좌우
    static int[] dc = { 0, 0,-1, 1};
    public static int[][] See(int[][] Map, int r, int c, int Dir){
        int i=1;
        while( r+i*dr[Dir]>=0 && r+i*dr[Dir]<N && c+i*dc[Dir]>=0 && c+i*dc[Dir]<M ){
            if(Map[r+i*dr[Dir]][c+i*dc[Dir]]==0) Map[r+i*dr[Dir]][c+i*dc[Dir]]=-1;
            else if(Map[r+i*dr[Dir]][c+i*dc[Dir]]==6) break;
            i++;
        }
        return Map;
    }
    public static int CntBlind(int[][] Map){
        int cnt=0;
        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                if(Map[r][c]==0) cnt++;
            }
        }
        return cnt;
    }
    public static void test_print(int[][] Map){
        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                System.out.printf("%2d",Map[r][c]);;
            }
            System.out.println();
        }
    }
    public static int[][] copy(int[][] Map){
        int[][] MapClone = new int[N][M];
        for(int r=0; r<N; r++)
            for(int c=0; c<M; c++)
                MapClone[r][c] = Map[r][c];
        return MapClone;
    }
}