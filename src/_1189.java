import java.io.*;
import java.util.*;

public class _1189 {

    static int R,C,T;
    static boolean[][] isBlocked; // isVisited 겸용
    static int result = 0;

    public static void main(String[] args) throws IOException{
        init();

        // 절대 알맞게 갈 수 없는 경우
        if((T-(R+C-1))%2!=0){
            System.out.println(0);
            return;
        }

        isBlocked[0][0] = true;
        dfs(0,0,1);
        System.out.println(result);
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        isBlocked = new boolean[R][C];
        for(int r=R-1; r>=0; r--){
            String str = br.readLine();
            for(int c=0; c<C; c++){
                isBlocked[r][c] = str.charAt(c)=='T';
            }
        }
    }

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    private static void dfs(int r, int c, int t){
//        System.out.printf("%d %d %d\n",r,c,t);

        int restTime = T-t;
        int distanceToGoal = Math.abs(R-1-r) + Math.abs(C-1-c);

        boolean usedAllTimes = restTime==0;
        boolean isArrived = distanceToGoal==0;
        if(usedAllTimes && isArrived){
            result++;
            return;
        }

        int tmp = restTime - distanceToGoal;
        if(tmp<0) return;

        for(int dir=0; dir<4; dir++){
            int nextR = r + dr[dir];
            int nextC = c + dc[dir];
            if(nextR>=0 && nextR<R && nextC>=0 && nextC<C && !isBlocked[nextR][nextC]){
                isBlocked[nextR][nextC] = true;
                dfs(nextR, nextC, t+1);
                isBlocked[nextR][nextC] = false;
            }
        }
    }
}
