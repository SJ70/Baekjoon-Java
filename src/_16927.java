import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16927 {
    static int R,C,ROTATECNT;
    static int[][] M;
    public static void main(String[] args) throws IOException{
        init();
        int SquareCnt = Math.min(R,C)/2;
        for(int i=0; i<SquareCnt; i++){
            int round = 2*R + 2*C - 8*i - 4; // 2*(R-1-i-i) + 2*(C-1-i-i)
            int rotateCnt_Min = ROTATECNT % round;
            for(int k=0; k<rotateCnt_Min; k++){
                MoveAround(i,i,R-1-i,C-1-i);
            }
        }
        PrintMatrix();
    }
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        ROTATECNT = Integer.parseInt(st.nextToken());
        M = new int[R][C];
        for(int r=0; r<R; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<C; c++){
                M[r][c] = Integer.parseInt(st.nextToken());
            }
        }
    }
    public static void MoveAround(int r1, int c1, int r2, int c2){
        int tmp = M[r1][c1];
        for(int c=c1; c<=c2-1; c++){
            M[r1][c] = M[r1][c+1];
        }
        for(int r=r1; r<=r2-1; r++){
            M[r][c2] = M[r+1][c2];
        }
        for(int c=c2; c>=c1+1; c--){
            M[r2][c] = M[r2][c-1];
        }
        for(int r=r2; r>=r1+2; r--){
            M[r][c1] = M[r-1][c1];
        }
        M[r1+1][c1] = tmp;
    }
    public static void PrintMatrix(){
        StringBuilder sb = new StringBuilder();
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                sb.append(M[r][c]).append(' ');
            }
            sb.append('\n');
        }
//        sb.append('\n');
        System.out.print(sb);
    }
}