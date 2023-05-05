import java.io.*;
import java.util.*;

public class _3055 {
    static int R,C;
    static char[][] Map;
    static Queue<int[]> Hedgehog = new ArrayDeque<>();
    static Queue<int[]> Water = new ArrayDeque<>();
    public static void main(String[] args) throws IOException{
        init();

        int result = 0;
        while(!Hedgehog.isEmpty()){
            result++;
            int repeat = Water.size();
            for(int i=0; i<repeat; i++){
                int r = Water.peek()[0];
                int c = Water.poll()[1];
                spread(r,c);
            }
            repeat = Hedgehog.size();
            for(int i=0; i<repeat; i++){
                int r = Hedgehog.peek()[0];
                int c = Hedgehog.poll()[1];
                try{
                    visit(r,c);
                }
                catch(Exception e){
                    System.out.println(result);
                    return;
                }
            }
        }
        System.out.println("KAKTUS");
    }
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Map = new char[R][C];
        for(int r=0; r<R; r++){
            String str = br.readLine();
            for(int c=0; c<C; c++){
                Map[r][c] = str.charAt(c);
                if(Map[r][c]=='S'){
                    Hedgehog.add(new int[]{r,c});
                }
                else if(Map[r][c]=='*'){
                    Water.add(new int[]{r,c});
                }
            }
        }
    }
    static int[][] dir = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
    public static void spread(int r, int c){
        for(int[] d : dir){
            int nextR = r+d[0];
            int nextC = c+d[1];
            if(nextR>=0 && nextR<R && nextC>=0 && nextC<C){
                if(Map[nextR][nextC]=='.'){
                    Map[nextR][nextC] = '*';
                    Water.add(new int[]{nextR,nextC});
                }
            }
        }
    }
    public static void visit(int r, int c) throws Exception{
        for(int[] d : dir){
            int nextR = r+d[0];
            int nextC = c+d[1];
            if(nextR>=0 && nextR<R && nextC>=0 && nextC<C){
                if(Map[nextR][nextC]=='.'){
                    Map[nextR][nextC] = 'S';
                    Hedgehog.add(new int[]{nextR,nextC});
                }
                else if(Map[nextR][nextC]=='D'){
                    throw new Exception();
                }
            }
        }
    }
}
