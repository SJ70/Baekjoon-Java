import java.io.*;
import java.util.*;

public class _2573 {
    public static void main(String[] args) throws IOException{
        Input();
        int Year = 0;
        //Print();
        while(!Qr.isEmpty()){
            if(isSeparated()){
                System.out.println(Year);
                break;
            }
            PredictMelt();
            Melt();
            Year++;
            //Print();
        }
        // 다 녹을 때까지 나누어지지 않은 경우
        if(Qr.isEmpty()) System.out.println(0);
    }
    static int N,M;
    static int[][] Map;
    static Queue<Integer> Qr = new ArrayDeque<>();
    static Queue<Integer> Qc = new ArrayDeque<>();
    // 얼음의 좌표를 큐에 추가
    public static void Input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Map = new int[N][M];
        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<M; c++){
                int n = Integer.parseInt(st.nextToken());
                if(n!=0){
                    Map[r][c]=n;
                    Qr.add(r);
                    Qc.add(c);
                }
            }
        }
    }
    static Queue<Integer> MeltR = new ArrayDeque<>();
    static Queue<Integer> MeltC = new ArrayDeque<>();
    static Queue<Integer> MeltCnt = new ArrayDeque<>();
    public static void PredictMelt(){
        while(!Qr.isEmpty()){
            int r = Qr.poll();
            int c = Qc.poll();
            MeltR.add(r);
            MeltC.add(c);
            MeltCnt.add(WaterNearby(r,c));
        }
    }
    public static void Melt(){
        while(!MeltR.isEmpty()){
            int r = MeltR.poll();
            int c = MeltC.poll();
            Map[r][c]-=MeltCnt.poll();
            // 얼음이 다 녹지 않았다면 다시 추가
            if(Map[r][c]>0){
                Qr.add(r);
                Qc.add(c);
            }
        }
    }
    // 큐의 첫번째 얼음이 모든 얼음과 이어져 있지 않은지
    static boolean[][] visited;
    static int cnt;
    public static boolean isSeparated(){
        visited = new boolean[N][M];
        cnt = 0;
        Visit(Qr.peek(),Qc.peek());
        // 이어져있는 얼음의 수 != 모든 얼음의 수
        return (cnt!=Qr.size());
    }
    public static void Visit(int r, int c){
        visited[r][c]=true;
        cnt++;
        // 방문하지 않았고 얼음이 있는 경우 방문
        if( !visited[r-1][c] && Map[r-1][c]>0 ) Visit(r-1,c);
        if( !visited[r+1][c] && Map[r+1][c]>0 ) Visit(r+1,c);
        if( !visited[r][c-1] && Map[r][c-1]>0 ) Visit(r,c-1);
        if( !visited[r][c+1] && Map[r][c+1]>0 ) Visit(r,c+1);
    }
    public static int WaterNearby(int r, int c){
        int water = 0;
        if(Map[r-1][c]<=0) water++;
        if(Map[r+1][c]<=0) water++;
        if(Map[r][c-1]<=0) water++;
        if(Map[r][c+1]<=0) water++;
        return water;
    }
    public static void Print(){
        System.out.println();
        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                if(Map[r][c]>0) System.out.printf("%3d",Map[r][c]);
                else System.out.print("  .");
            }
            System.out.println();
        }
    }
}
/*
4 5
0 0 0 0 0
0 9 3 9 0
0 0 1 0 0
0 0 0 0 0

3 5
0 0 0 0 0
0 9 5 9 0
0 0 0 0 0

3 5
0 0 0 0 0
0 9 0 9 0
0 0 0 0 0
*/