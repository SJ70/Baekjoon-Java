import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1103 {
    static int R,C;
    static int[][] M;
    static Integer[][] Movable;
    static final int HOLE = 0;
    public static void main(String[] args) throws IOException{
        init();
        getMovableValue(0,0);
//        printMovable();
        System.out.println( Cycle ? -1 : Movable[0][0] );
    }
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = new int[R][C];
        Movable = new Integer[R][C];
        for(int r=0; r<R; r++){
            String str = br.readLine();
            for(int c=0; c<C; c++){
                if(str.charAt(c)!='H')
                    M[r][c] = str.charAt(c)-'0';
            }
        }
        calculated = new boolean[R][C];
    }

    // 이전에 계산을 시도한 칸을 다시 계산하려 한다면 사이클이 발생
    static boolean[][] calculated;
    static boolean Cycle = false;
    public static int getMovableValue(int r, int c){
        if(Cycle) return -1;
        if(Movable[r][c]==null){
            if(calculated[r][c]){
                Cycle = true;
                return -1;
            }
            else{
                calculated[r][c]=true;
            }

            if(M[r][c]==HOLE){
                Movable[r][c] = 0;
            }
            else{
                int up,down,left,right;
                up=down=left=right=0;
                if(r-M[r][c]>=0)    up = getMovableValue(r-M[r][c],c);
                if(r+M[r][c]<R)   down = getMovableValue(r+M[r][c],c);
                if(c-M[r][c]>=0)  left = getMovableValue(r,c-M[r][c]);
                if(c+M[r][c]<C)  right = getMovableValue(r,c+M[r][c]);
                Movable[r][c] = 1 + Math.max(Math.max(up,down),Math.max(left,right));
            }
        }
        return Movable[r][c];
    }
    public static void printMovable(){
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(Movable[r][c]==null) System.out.print("  .");
                else System.out.printf("%3d",Movable[r][c]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
