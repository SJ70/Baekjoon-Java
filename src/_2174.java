import java.io.*;
import java.util.*;

public class _2174 {
    public static void main(String[] args) throws IOException {
        Init();
        for(int i=0; i<commandCnt; i++){
            st = new StringTokenizer(br.readLine());
            Command( Integer.parseInt(st.nextToken()), st.nextToken().charAt(0), Integer.parseInt(st.nextToken()) );
            if(Crashed) return;
        }
        System.out.println("OK");
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int R,C, robotCnt, commandCnt;
    static int[][] Map;
    static Robot[] Robots;
    public static class Robot{
        int r,c,dir;
        public Robot(int r, int c, int dir){
            this.r=r; this.c=c; this.dir=dir;
        }
    }
    static final int[][] Dir = {{1,0},{0,1},{-1,0},{0,-1}}; // N,E,S,W : 지문에는 0,0이 좌측하단 이므로 N과 S의 방향이 반대
    public static void Init() throws IOException{
        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Map = new int[R+1][C+1];
        st = new StringTokenizer(br.readLine());
        robotCnt = Integer.parseInt(st.nextToken());
        Robots = new Robot[robotCnt+1];
        commandCnt = Integer.parseInt(st.nextToken());
        for(int i=1; i<=robotCnt; i++){
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            Robots[i] = new Robot(r,c,dir=='N'?0:dir=='E'?1:dir=='S'?2:3);
            Map[r][c] = i;  // 맵에 로봇 인덱스 저장
        }
    }
    static boolean Crashed = false;
    public static void Command(int num, char command, int repeat) throws IOException{
        for(int i=0; i<repeat; i++){
            if(command=='L' || command=='R'){
                int dir = command=='L' ? -1 : 1;
                Robots[num].dir += dir;
                if(Robots[num].dir < 0) Robots[num].dir = 3;
                else if(Robots[num].dir > 3) Robots[num].dir = 0;
            }
            else{ // F
                //PrintMap();
                Map[Robots[num].r][Robots[num].c]=0;
                Robots[num].r += Dir[Robots[num].dir][0];
                Robots[num].c += Dir[Robots[num].dir][1];
                if (Robots[num].r<=0 || Robots[num].r>R || Robots[num].c<=0 || Robots[num].c>C){
                    System.out.println("Robot "+num+" crashes into the wall");
                    Crashed = true;
                    return;
                }
                else if(Map[Robots[num].r][Robots[num].c]!=0){
                    System.out.println("Robot "+num+" crashes into robot "+Map[Robots[num].r][Robots[num].c]);
                    Crashed = true;
                    return;
                }
                Map[Robots[num].r][Robots[num].c]=num;
            }
        }
    }
    public static void PrintMap(){
        for(int r=R; r>=1; r--){
            for(int c=1; c<=C; c++){
                System.out.print(Map[r][c]==0?".":Map[r][c]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
