import java.io.*;
import java.util.*;

public class _1932 {
    static int N;
    static int[][] Map;
    public static void main(String[] args) throws IOException {
        Input();
        //Print();
        dp();
        //Print();
        System.out.println(Map[0][0]);
    }
    public static void dp(){
        for(int r=N-2; r>=0; r--){
            for(int c=0; c<=r; c++){
                Map[r][c] += Math.max(Map[r+1][c],Map[r+1][c+1]);
            }
        }
    }
    public static void Input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Map = new int[N][N];
        for(int r=0; r<N; r++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c=0; c<=r; c++){
                Map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
    }
    public static void Print(){
        for(int r=0; r<N; r++){
            for(int i=0; i<N-r; i++)
                System.out.printf("  ");
            for(int c=0; c<=r; c++){
                System.out.printf("%4d",Map[r][c]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
