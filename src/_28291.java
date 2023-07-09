import java.io.*;
import java.util.*;

public class _28291 {
    static int R,C;
    static Integer[][] Map;
    static Queue<int[]> RedStoneSignal = new ArrayDeque<>();
    static Queue<int[]> Lamp = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        input();
//        printMap();
        bfs();
//        printMap();
        System.out.println(isSuccess()?"success":"failed");
    }
    public static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        Map = new Integer[R][C];
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String value = st.nextToken();
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            switch(value.charAt(9)){
                case 'b' :
                    RedStoneSignal.add(new int[]{r,c});
                    Map[r][c] = 16;
                    break;
                case 'd' :
                    Map[r][c] = 0;
                    break;
                case 'l' :
                    Lamp.add(new int[]{r,c});
                    Map[r][c] = -1;
                    break;
            }
        }
    }
    public static void bfs(){
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!RedStoneSignal.isEmpty()){
            int repeat = RedStoneSignal.size();
            for(int i=0; i<repeat; i++){
                int r = RedStoneSignal.peek()[0];
                int c = RedStoneSignal.poll()[1];
                int value = Map[r][c];
                if(value==1) continue;
                for(int[] d : dir){
                    int nextR = r+d[0];
                    int nextC = c+d[1];
                    if(nextR>=0 && nextR<R && nextC>=0 && nextC<C && Map[nextR][nextC]!=null){
                        if(Map[nextR][nextC]==0){
                            Map[nextR][nextC] = value-1;
                            RedStoneSignal.add(new int[]{nextR,nextC});
                        }
                        else if(Map[nextR][nextC]==-1){
                            Map[nextR][nextC] = value-1;
                        }
                    }
                }
            }
        }
    }
    public static boolean isSuccess(){
        for(int[] pos: Lamp){
            int r = pos[0];
            int c = pos[1];
            if(Map[r][c]==-1) return false;
        }
        return true;
    }
//    public static void printMap(){
//        for(int r=0; r<R; r++){
//            for(int c=0; c<C; c++){
//                System.out.printf("%5d",Map[r][c]);
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }
}
