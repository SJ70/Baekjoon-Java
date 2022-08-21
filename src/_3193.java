import java.util.*;
import java.io.*;

public class _3193 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, K;
    static char[][] Map;
    static int BallR, BallC;
    static int GIndex = 0;
    static final int[][] gravity = {{ 1, 0},{ 0, 1},{-1, 0},{ 0,-1}};
    public static void main(String[] args) throws IOException{
        Init();
        for(int i=0; i<K; i++){
            ChangeGravity(br.readLine().charAt(0));
            FallBall();
        }
        PrintMap();
    }
    public static void Init() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Map = new char[N][N];
        for(int r=0; r<N; r++){
            String str = br.readLine();
            for(int c=0; c<N; c++){
                char C = str.charAt(c);
                if(C=='L'){
                    BallR=r; BallC=c;
                    Map[r][c]='.';
                }
                else Map[r][c]=C;
            }
        }
    }
    public static void ChangeGravity(char c){
        if(c=='L') GIndex--;
        else GIndex++;
        if(GIndex<0) GIndex=3;
        else if(GIndex>3) GIndex=0;
    }
    public static void FallBall(){
        while(true){
            int nextR = BallR+gravity[GIndex][0];
            int nextC = BallC+gravity[GIndex][1];
            if(nextR<0 || nextR>=N || nextC<0 || nextC>=N || Map[nextR][nextC]=='X') return;
            BallR=nextR; BallC=nextC;
        }
    }
    public static void PrintMap() throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map[BallR][BallC]='L';
        switch(GIndex){
            case 0:
                for(int r=0; r<N; r++){
                    for(int c=0; c<N; c++){
                        bw.write(Map[r][c]);
                    }
                    bw.write("\n");
                }
                break;
            case 1:
                for(int c=0; c<N; c++){
                    for(int r=N-1; r>=0; r--){
                        bw.write(Map[r][c]);
                    }
                    bw.write("\n");
                }
                break;
            case 2:
                for(int r=N-1; r>=0; r--){
                    for(int c=N-1; c>=0; c--){
                        bw.write(Map[r][c]);
                    }
                    bw.write("\n");
                }
                break;
            case 3:
                for(int c=N-1; c>=0; c--){
                    for(int r=0; r<N; r++){
                        bw.write(Map[r][c]);
                    }
                    bw.write("\n");
                }
                break;
        }
        bw.flush();
        bw.close();
    }
}
