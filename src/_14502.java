import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _14502 {
    public static void main(String[] args) throws IOException{
        init();
        makeWall(0,0);
        System.out.print(MaxSafeSpace);
    }
    static int R,C;
    static int[][] Map;
    static final int EMPTY = 0;
    static final int WALL = 1;
    static final int VIRUS = 2;
    static final int MAKE_WALL_CNT = 3;
    static ArrayList<int[]> emptyPos = new ArrayList<>();
    static ArrayList<int[]> virusPos = new ArrayList<>();
    static int MaxSafeSpace = -1;
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        Map = new int[R][C];
        for(int r=0; r<R; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<C; c++){
                Map[r][c] = Integer.parseInt(st.nextToken());
                if(Map[r][c]==EMPTY) emptyPos.add(new int[]{r,c});
                else if(Map[r][c]==VIRUS) virusPos.add(new int[]{r,c});
            }
        }
    }

    //백트래킹
    public static void makeWall(int index, int wallCnt){
        if(wallCnt==MAKE_WALL_CNT){
            countSafeSpace();
//            printMap();
            return;
        }
        if(index == emptyPos.size()) return;
        int r = emptyPos.get(index)[0];
        int c = emptyPos.get(index)[1];

        Map[r][c] = WALL;
        makeWall(index+1,wallCnt+1);

        Map[r][c] = EMPTY;
        makeWall(index+1,wallCnt);
    }

    static Queue<int[]> infectedPos = new ArrayDeque<>();
    public static void countSafeSpace(){
        for(int[] virus : virusPos){
            infectVirus(virus[0],virus[1]);
        }

        int safeSpace = emptyPos.size() - infectedPos.size() - MAKE_WALL_CNT;
        MaxSafeSpace = Math.max( MaxSafeSpace, safeSpace);

        restoreInfection();
    }
    //DFS
    public static void infectVirus(int r, int c){
        if(Map[r][c]==EMPTY){
            Map[r][c]=VIRUS;
            infectedPos.add(new int[]{r,c});
        }
        if(r-1>=0 && Map[r-1][c]==EMPTY) infectVirus(r-1,c);
        if(r+1<R  && Map[r+1][c]==EMPTY) infectVirus(r+1,c);
        if(c-1>=0 && Map[r][c-1]==EMPTY) infectVirus(r,c-1);
        if(c+1<C  && Map[r][c+1]==EMPTY) infectVirus(r,c+1);
    }

    public static void restoreInfection(){
        while(!infectedPos.isEmpty()){
            int[] pos = infectedPos.poll();
            Map[pos[0]][pos[1]] = EMPTY;
        }
    }

    public static void printMap(){
        StringBuilder sb = new StringBuilder();
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                sb.append(Map[r][c]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
