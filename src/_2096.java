import java.io.*;
import java.util.StringTokenizer;

public class _2096 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int R;
    static int[][] Min,Max;
    public static void main(String[] args) throws IOException {
        R = Integer.parseInt(br.readLine());
        Min = new int[R][3];
        Max = new int[R][3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int c=0; c<3; c++){
            Min[0][c] = Max[0][c] = Integer.parseInt(st.nextToken());
        }
        for(int r=1; r<R; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<3; c++){
                Min[r][c] = Max[r][c] = Integer.parseInt(st.nextToken());
            }
            Min[r][0] += Math.min(Min[r-1][0],Min[r-1][1]);
            Min[r][1] += Math.min(Min[r-1][0],Math.min(Min[r-1][1],Min[r-1][2]));
            Min[r][2] += Math.min(Min[r-1][1],Min[r-1][2]);
            Max[r][0] += Math.max(Max[r-1][0],Max[r-1][1]);
            Max[r][1] += Math.max(Max[r-1][0],Math.max(Max[r-1][1],Max[r-1][2]));
            Max[r][2] += Math.max(Max[r-1][1],Max[r-1][2]);
        }
        System.out.print(Math.max(Max[R-1][0],Math.max(Max[R-1][1],Max[R-1][2]))+" ");
        System.out.print(Math.min(Min[R-1][0],Math.min(Min[R-1][1],Min[R-1][2])));
    }
}
