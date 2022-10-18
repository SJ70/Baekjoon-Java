import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2167 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int R,C;
    static int[][] Arr;
    public static void main(String[] args) throws IOException{
        init();
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            int sum = GetSquareSum(r1,c1,r2,c2);
            sb.append(sum).append('\n');
        }
        System.out.print(sb);
    }
    public static void init() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Arr = new int[R+1][C+1];
        for(int r=1; r<=R; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=1; c<=C; c++){
                Arr[r][c] = Integer.parseInt(st.nextToken()) + Arr[r-1][c] + Arr[r][c-1] - Arr[r-1][c-1];
            }
        }
    }
    public static int GetSquareSum(int r1, int c1, int r2, int c2){
        return Arr[r2][c2] - Arr[r1-1][c2] - Arr[r2][c1-1] + Arr[r1-1][c1-1];
    }
}
