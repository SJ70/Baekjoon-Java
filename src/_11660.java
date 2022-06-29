import java.io.*;
import java.util.*;

public class _11660 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        Input();
        //Print();
        for(int i=0; i<M; i++){
            bw.write(String.valueOf(GetSquare())+'\n');
        }
        bw.flush();
        bw.close();
    }
    static int N,M;
    static int[][] Map;
    public static void Input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Map = new int[N][N];
        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                Map[r][c] = Integer.parseInt(st.nextToken()) + GetValue(r-1,c) + GetValue(r,c-1) - GetValue(r-1,c-1);
            }
        }
    }
    public static int GetValue(int r, int c){
        if( r<0 || c<0 ) return 0;
        else return Map[r][c];
    }
    public static void Print(){
        for(int r=0; r<N; r++){
            System.out.println();
            for(int c=0; c<N; c++){
                System.out.printf("%3d",Map[r][c]);
            }
        }
    }
    public static int GetSquare() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken()) -1;
        int c1 = Integer.parseInt(st.nextToken()) -1;
        int r2 = Integer.parseInt(st.nextToken()) -1;
        int c2 = Integer.parseInt(st.nextToken()) -1;
        return Map[r2][c2] - GetValue(r1-1,c2) - GetValue(r2,c1-1) + GetValue(r1-1,c1-1);
    }
}
