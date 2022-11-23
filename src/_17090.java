import java.io.*;
import java.util.StringTokenizer;

public class _17090 {
    static int R,C;
    static char[][] Map;
    static boolean[][] canEscape;
    static int EscapeAbleCnt = 0;
    public static void main(String[] args) throws IOException{
        init();
        for(int r=0; r<R; r++){
            if(Map[r][0]=='L') visit(r,0);
            if(Map[r][C-1]=='R') visit(r,C-1);
        }
        for(int c=0; c<C; c++){
            if(Map[0][c]=='U') visit(0,c);
            if(Map[R-1][c]=='D') visit(R-1,c);
        }
        System.out.println(EscapeAbleCnt);
    }
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Map = new char[R][C];
        canEscape = new boolean[R][C];
        for(int r=0; r<R; r++){
            String str = br.readLine();
            for(int c=0; c<C; c++){
                Map[r][c] = str.charAt(c);
            }
        }
    }
    public static void visit(int r, int c){
//        printStatus();
        canEscape[r][c] = true;
        EscapeAbleCnt++;

        if(r-1>=0 && Map[r-1][c]=='D' && !canEscape[r-1][c]) visit(r-1,c);
        if(r+1<R && Map[r+1][c]=='U' && !canEscape[r+1][c]) visit(r+1,c);
        if(c-1>=0 && Map[r][c-1]=='R' && !canEscape[r][c-1]) visit(r,c-1);
        if(c+1<C && Map[r][c+1]=='L' && !canEscape[r][c+1]) visit(r,c+1);
    }
    public static void printStatus(){
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                System.out.print(canEscape[r][c] ? "o" : ".");
            }
            System.out.println();
        }
        System.out.println();
    }
}
