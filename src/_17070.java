import java.io.*;
import java.util.StringTokenizer;

public class _17070 {
    static int N;
    static int[][][] arr; // [row][column][dir]
    static boolean[][] isBlocked;
    static final int R = 0;
    static final int D = 1;
    static final int RD = 2;

    public static void main(String[] args) throws IOException{
        input();

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(ableToBuild(r,c,RD))
                    arr[r][c][RD] += getValueFrom(r-1,c-1,RD) + getValueFrom(r-1,c-1,R) + getValueFrom(r-1,c-1,D);
                if(ableToBuild(r,c,D))
                    arr[r][c][D] += getValueFrom(r-1,c,RD) + getValueFrom(r-1,c,D);
                if(ableToBuild(r,c,R))
                    arr[r][c][R] += getValueFrom(r,c-1,RD) + getValueFrom(r,c-1,R);
            }
        }

//        printArr();

        System.out.println( arr[N-1][N-1][R] + arr[N-1][N-1][D] + arr[N-1][N-1][RD] );
    }

    public static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N][3];
        arr[0][1][R] = 1;

        isBlocked = new boolean[N][N];
        for(int r=0; r<N; r++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                isBlocked[r][c] = st.nextToken().charAt(0)=='1';
            }
        }
    }

    public static boolean ableToBuild(int r, int c, int dir){
        if(isBlocked[r][c]) return false;
        if(dir==RD) return (r-1>=0 && c-1>=0 && !isBlocked[r-1][c] && !isBlocked[r][c-1]);
        else return true;
    }

    public static int getValueFrom(int r, int c, int dir){
        if(r<0 || c<0) return 0;
        return arr[r][c][dir];
    }

    public static void printArr(){
        for(int d=0; d<3; d++){
            System.out.println(d);
            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){
                    System.out.printf("%3d",arr[r][c][d]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
