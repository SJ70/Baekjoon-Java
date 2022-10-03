import java.util.Scanner;

public class _10997 {
    static boolean[][] Map;
    static int N,R,C;
    public static void main(String[] args){
        N = new Scanner(System.in).nextInt();
        if(N==1){
            System.out.print('*');
            return;
        }
        C = (N*2-1)*2-1;
        R = C+2;
        Map = new boolean[R][C];
        FillMap(0,C-1,LEFT);
        PrintMap();
    }
    static final int LEFT = 0;
    static final int DOWN = 1;
    static final int RIGHT = 2;
    static final int UP = 3;
    static int[] dr = { 0, 1, 0,-1};
    static int[] dc = {-1, 0, 1, 0};
    public static int TurnDir(int dir){
        dir++;
        if(dir>3) dir=0;
        return dir;
    }
    public static void FillMap(int r, int c, int dir){
        //PrintMap();
        Map[r][c]=true;
        if(isFinalPos(r,c)) return;
        int NextR = r+dr[dir];
        int NextC = c+dc[dir];
        if(isOutOfBound(NextR,NextC) || (!isOutOfBound(NextR+dr[dir],NextC+dc[dir]) && isBlocked(NextR+dr[dir],NextC+dc[dir])) ){
            dir=TurnDir(dir);
        }
        FillMap(r+dr[dir],c+dc[dir],dir);
    }
    public static boolean isOutOfBound(int r, int c){
        return (r<0 || r>=R || c<0 || c>=C);
    }
    public static boolean isBlocked(int r, int c){
        return Map[r][c];
    }
    public static boolean isFinalPos(int r, int c){
        return r==R/2+1 && c==C/2;
    }
    public static void PrintMap(){
        StringBuilder sb = new StringBuilder();
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(r==1 && c>0) break;  // 불필요한 공백 제거
                sb.append(Map[r][c]?'*':' ');
            }
            if(r<R-1) sb.append('\n');
        }
        System.out.print(sb);
    }
}
