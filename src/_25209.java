import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _25209 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int R,C;
    static char[][] LargeMap;
    static char[][] Map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        init();
        printMap();
        try{
            for(int r=0; r<R; r++)
                for(int c=0; c<C; c++)
                    if(!visited[r][c])
                        visit(r,c);
        }
        catch(Exception e){
            System.out.println("NO");
            return;
        }
        System.out.println("YES");
    }
    public static void init() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        fillLargeMap();
        fillSmallMap();
        visited = new boolean[R][C];
    }
    public static void fillLargeMap() throws IOException{
        LargeMap = new char[3*R][3*C];
        for(int r=0; r<3*R; r++){
            String str = br.readLine();
            for(int c=0; c<3*C; c++){
                LargeMap[r][c] = str.charAt(c);
            }
        }
    }
    public static void fillSmallMap(){
        Map = new char[R][C];
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                switch(LargeMap[3*r+1][3*c+1]){
                    case'#':
                        if(LargeMap[3*r][3*c]=='.') Map[r][c] = '◢';
                        else if(LargeMap[3*r+2][3*c+2]=='.') Map[r][c] = '◤';
                        else if(LargeMap[3*r][3*c+2]=='.') Map[r][c] = '◣';
                        else if(LargeMap[3*r+2][3*c]=='.') Map[r][c] = '◥';
                        else Map[r][c] = '⬛';
                        break;
                    default:
                        Map[r][c] = LargeMap[3*r+1][3*c+1];
                        break;
                }
            }
        }
    }
    public static void printMap(){
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                System.out.printf("%2c",Map[r][c]);
            }
            System.out.println();
        }
    }
    public static void visit(int r, int c) throws Exception{
        visited[r][c] = true;

        // 축과 평행한 직사각형
        switch(Map[r][c]){
            case'⬛': break;
            case'◢': throw new Exception(); // 좌측상단부터 탐색하기에 나와선 안 되는 존재
            case'◣': throw new Exception();
            case'◥': throw new Exception();
            case'◤': // 좌측상단부터 탐색하기에 width 초깃값 1
                checkTiltedSquare(r,c,'◤',c+1,'◥');
                break;
            case'.':
                checkSquare(r,c);
                break;
            default: //숫자
                checkTriangleNearby(r,c,Map[r][c]-'0');
                break;
        }
    }
    public static void checkTriangleNearby(int r, int c, int n) throws Exception{
        int cnt = 0;
        if(r-1>=0 && isTriangle(Map[r-1][c])) cnt++;
        if(r+1<R && isTriangle(Map[r+1][c]))  cnt++;
        if(c-1>=0 && isTriangle(Map[r][c-1])) cnt++;
        if(c+1<C && isTriangle(Map[r][c+1]))  cnt++;
        if(cnt!=n) throw new Exception();
    }
    public static boolean isTriangle(char c){
        return c=='◤' || c=='◢' || c=='◣' || c=='◥';
    }
    public static void checkSquare(int r, int c) throws Exception{
        int width = 0;
        for(int j=c+1; j<C; j++){
            if(Map[r][j]!='.') break;

            visited[r][j] = true;
            width++;
        }
        for(int i=r+1; i<R; i++){
            if(Map[i][c]!='.') break;

            for(int j=c; j<=c+width; j++){
                visited[i][j] = true;
                if(Map[i][j]!='.') throw new Exception();
            }
        }
    }
    public static void checkTiltedSquare(int r, int c1, char char1, int c2, char char2) throws Exception{
        System.out.printf("r:%d, %d:%c ~ %d:%c\n",r,c1,char1,c2,char2);
        if(c1>=0 && Map[r][c1]==char1) visited[r][c1] = true;
        else throw new Exception();

        if(c2<C && Map[r][c2]==char2) visited[r][c2] = true;
        else throw new Exception();

        for(int i=c1+1; i<=c2-1; i++){
            if(i<C && Map[r][i]=='.') visited[r][i] = true;
            else throw new Exception();
        }

        // leftExpanding / rightExpanding
        boolean L_Exp = (char1=='◤');
        boolean R_Exp = (char2=='◥');
        // 확장/축소 초깃값 : 현재 상황
        int  Next_c1    = L_Exp ? c1-1 : c1+1;
        char Next_char1 = L_Exp ? '◤' : '◣';
        int  Next_c2    = R_Exp ? c2+1 : c2-1;
        char Next_char2 = R_Exp ? '◥' : '◢';
        // 확장 중일 경우 축소를 확인
        if(r+1>=R) throw new Exception();
        if(L_Exp && Map[r+1][c1]=='◣'){
            Next_char1 = '◣';
            Next_c1 = c1;
        }
        if(R_Exp && Map[r+1][c2]=='◢'){
            Next_char2 = '◢';
            Next_c2 = c2;
        }

        // 양쪽 다 수축 중이고 c1과 c2가 1 차이라면 끝 (다음을 탐색하지 않음)
        if(!L_Exp && !R_Exp && c2-c1==1) return;

        checkTiltedSquare(r+1, Next_c1, Next_char1, Next_c2, Next_char2);
    }
}