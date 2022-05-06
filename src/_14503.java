import java.io.*;
import java.util.StringTokenizer;

public class _14503 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dr = {-1, 0, 1, 0}; // 북 동 남 서
    static int[] dc = { 0, 1, 0,-1};
    static int r,c;
    static int d;
    static int[][] map; // 0:빈공간, 1:벽, 2:청소된 공간
    static int CleanCnt = 0;
    static int N,M;
    static int turnCnt = 0;

    public static boolean FowardIsDirty(){
        return ( map [r+dr[d]] [c+dc[d]] ) == 0;
    }
    public static void TurnLeft(){
        d--;
        if(d<0) d=3;
    }
    public static void Go(){
        r+=dr[d];
        c+=dc[d];
    }
    public static void Clean(){
        if(map[r][c]==0){
            map[r][c] = 2;
            CleanCnt++;
        }
    }

    public static boolean isBackWall(){
        return ( map [r-dr[d]] [c-dc[d]] ) == 1;
    }
    public static void GoBack(){
        r-=dr[d];
        c-=dc[d];
    }

    public static void Input() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void test_print() throws IOException{
        System.out.println();
        for(int i=0;i<N;i++){
            System.out.println();
            for(int j=0;j<M;j++)
                System.out.print(map[i][j]+" ");
        }
        System.out.println(" ("+r+","+c+","+d+") "+CleanCnt);
    }

    public static void main(String[] args) throws IOException{
        Input();

        // 시작
        map[r][c]=2;
        CleanCnt++;

        while(true){
            //test_print();
            TurnLeft();
            if(FowardIsDirty()){
                turnCnt = 0;
                Go();
                Clean();
            }
            else{
                turnCnt++;
                if(turnCnt==4){
                    if(isBackWall()){
                        break;
                    }
                    else{
                        turnCnt=0;
                        GoBack();
                        Clean();
                    }
                }
            }
        }
        System.out.println(CleanCnt);
    }
}