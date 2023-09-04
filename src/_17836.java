import java.io.*;
import java.util.*;

public class _17836 {
    private static int R, C, TimeLimit;
    private static int ResultTime = Integer.MAX_VALUE;
    private static int ResultTimeWithGram = Integer.MAX_VALUE;
    private static int[][] Map;
    private static boolean[][] isVisited;
    private static Queue<int[]> Q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        init();

        Q.add(new int[]{0, 0, 0});
        Map[0][0] = 1;
        while(!Q.isEmpty()){
            dfs(Q.peek()[0], Q.peek()[1], Q.poll()[2]);
        }

        int result = Math.min(ResultTime, ResultTimeWithGram);
        System.out.println(result == Integer.MAX_VALUE ? "Fail" : result);
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        TimeLimit = Integer.parseInt(st.nextToken());

        Map = new int[R][C];
        for(int r=0; r<R; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<C; c++){
                Map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        isVisited = new boolean[R][C];
    }

    private static int[] dr = {1, 0, -1, 0};
    private static int[] dc = {0, 1, 0, -1};

    private static void dfs(int r, int c, int time){
        if(time > TimeLimit){
            Q.clear();
            return;
        }
        if(Map[r][c]==2){
            ResultTimeWithGram = Math.min(time + R-1 - r + C-1 - c, ResultTimeWithGram);
            if(ResultTimeWithGram > TimeLimit) ResultTimeWithGram = Integer.MAX_VALUE;
        }
        if(r == R-1 && c == C-1){
            ResultTime = time;
            Q.clear();
        }

        for(int dir=0; dir<4; dir++){
            int nextR = r + dr[dir];
            int nextC = c + dc[dir];

            if(nextR < 0 || nextR == R || nextC < 0 || nextC == C){
                continue;
            }
            if(isVisited[nextR][nextC] || Map[nextR][nextC]==1){
                continue;
            }

            Q.add(new int[] {nextR, nextC, time + 1});
            isVisited[nextR][nextC] = true;
        }
    }
}
