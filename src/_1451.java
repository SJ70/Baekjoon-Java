import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1451 {
    static int R,C;
    static long[][] Prefix_Sum;
    public static void main(String[] args) throws IOException{
        Init();
        MakeSquare(0,1,1,R,C);
        System.out.print(Result_Max);
    }
    public static void Init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Prefix_Sum = new long[R+1][C+1];
        for(int r=1; r<=R; r++){
            String str = br.readLine();
            for(int c=1; c<=C; c++){
                Prefix_Sum[r][c] = str.charAt(c-1)-'0' + Prefix_Sum[r-1][c] + Prefix_Sum[r][c-1] - Prefix_Sum[r-1][c-1];
            }
        }
    }
    static final int SquareCnt = 3;
    static long[] Squares = new long[3];
    static long Result_Max = 0;
    public static void MakeSquare(int cnt, int r1, int c1, int r2, int c2){
        if(cnt==SquareCnt-1){
            Squares[cnt] = GetSquareSum(r1,c1,r2,c2);
            long Multiply = 1;
            for(int i=0; i<SquareCnt; i++){
                Multiply *= Squares[i];
                //System.out.print(Squares[i]+",");
            }
            //System.out.println();
            Result_Max = Math.max(Result_Max,Multiply);
            return;
        }
        for(int r=r1; r<r2; r++){
            Squares[cnt] = GetSquareSum(r1,c1,r,c2);
            MakeSquare(cnt+1,r+1,c1,r2,c2);
        }
        for(int c=c1; c<c2; c++){
            Squares[cnt] = GetSquareSum(r1,c1,r2,c);
            MakeSquare(cnt+1,r1,c+1,r2,c2);
        }
        if(cnt==0){
            for(int r=r1+1; r<=r2; r++){
                Squares[cnt] = GetSquareSum(r,c1,r2,c2);
                MakeSquare(cnt+1,r1,c1,r-1,c2);
            }
            for(int c=c1+1; c<=c2; c++){
                Squares[cnt] = GetSquareSum(r1,c,r2,c2);
                MakeSquare(cnt+1,r1,c1,r2,c-1);
            }
        }
    }
    public static long GetSquareSum(int r1, int c1, int r2, int c2){
        return Prefix_Sum[r2][c2] - Prefix_Sum[r2][c1-1] - Prefix_Sum[r1-1][c2] + Prefix_Sum[r1-1][c1-1];
    }
}