import java.io.*;
import java.util.*;

public class _17484 {
    static int R,C;
    static int[][][] cost;

    public static void main(String[] args) throws IOException{
        init();
        DP();
        System.out.println(getMinCost(cost));
    }

    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        cost = new int[R][C][3]; // column, direction
        for(int r=0; r<R; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<C; c++){
                int value = Integer.parseInt(st.nextToken());
                for(int d=0; d<3; d++){
                    cost[r][c][d] = value;
                }
            }
        }
    }

    public static void DP(){
        for(int r=1; r<R; r++){
            for(int c=0; c<C; c++){
                cost[r][c][0] += (c==0) ? 100000 : Math.min( getValue(r-1,c-1,1), getValue(r-1,c-1,2) );
                cost[r][c][1] += Math.min( getValue(r-1,c,0), getValue(r-1,c,2) );
                cost[r][c][2] += (c==C-1) ? 100000 : Math.min( getValue(r-1,c+1,0), getValue(r-1,c+1,1) );
//                System.out.printf("%d %d %d \n",cost[r][c][0],cost[r][c][1],cost[r][c][2]);
            }
        }
    }

    public static int getValue(int r, int c, int dir){
        return (c>=0 && c<C) ? cost[r][c][dir] : Integer.MAX_VALUE;
    }

    public static int getMinCost(int[][][] arr){
        int result = Integer.MAX_VALUE;
        for(int e[] : arr[R-1]){
            for(int f : e){
                result = Math.min(f, result);
            }
        }
        return result;
    }
}
