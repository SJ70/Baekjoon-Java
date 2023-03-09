import java.io.*;
import java.util.*;

public class _1913 {
    static int N, K;
    static int[][] arr;
    public static void main(String[] args) throws IOException{
        init();
        fill(0,0,0,N*N);
        print();
    }
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        arr = new int[N][N];
    }
    static int[] dr = new int[]{1,0,-1,0};
    static int[] dc = new int[]{0,1,0,-1};
    public static void fill(int r, int c, int dir, int num){
        if(num==0) return;
        arr[r][c] = num;
        int nextR = r+dr[dir];
        int nextC = c+dc[dir];
        if(nextR<0 || nextR==N || nextC<0 || nextC==N || arr[nextR][nextC]!=0){
            dir++;
            if(dir==4) dir=0;
            nextR = r+dr[dir];
            nextC = c+dc[dir];
        }
        fill(nextR, nextC, dir,num-1);
    }
    public static void print(){
        StringBuilder sb = new StringBuilder();
        int targetR = 0;
        int targetC = 0;
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(c!=0) sb.append(' ');
                sb.append(arr[r][c]);
                if(arr[r][c]==K){
                    targetR=r;
                    targetC=c;
                }
            }
            sb.append('\n');
        }
        sb.append(targetR+1).append(' ').append(targetC+1);
        System.out.println(sb);
    }
}
