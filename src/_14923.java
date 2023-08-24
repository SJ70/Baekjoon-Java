import java.io.*;
import java.util.*;

public class _14923 {

    private static class Status{
        int brokenWall, r, c, time;
        public Status(int brokenWall, int r, int c, int time){
            this.brokenWall = brokenWall;
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    static int R, C, targetR, targetC;
    static boolean[][] isWall;
    static boolean[][][] isVisited; // [벽파괴횟수][r][c]
    static Queue<Status> StatusQ = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(getResult());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int startR = Integer.parseInt(st.nextToken()) -1;
        int startC = Integer.parseInt(st.nextToken()) -1;
        StatusQ.add(new Status(0, startR, startC, 0));

        st = new StringTokenizer(br.readLine());
        targetR = Integer.parseInt(st.nextToken()) -1;
        targetC = Integer.parseInt(st.nextToken()) -1;

        isWall = new boolean[R][C];
        for(int r=0; r<R; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<C; c++){
                isWall[r][c] = st.nextToken().charAt(0) == '1';
            }
        }

        isVisited = new boolean[2][R][C];
        isVisited[0][startR][startC] = true;
    }

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    private static int getResult(){
        while(!StatusQ.isEmpty()){
            Status status = StatusQ.poll();

            if(status.r == targetR && status.c == targetC) return status.time;

            for(int dir=0; dir<4; dir++){
                int nextR = status.r + dr[dir];
                int nextC = status.c + dc[dir];
                if(nextR<0 || nextR==R || nextC<0 || nextC==C) continue;
                if(isVisited[status.brokenWall][nextR][nextC]) continue;
                if(isWall[nextR][nextC]){
                    if(status.brokenWall==0 && !isVisited[1][nextR][nextC]){
                        StatusQ.add(new Status(1, nextR, nextC, status.time+1));
                        isVisited[1][nextR][nextC] = true;
                    }
                }
                else{
                    StatusQ.add(new Status(status.brokenWall, nextR, nextC, status.time+1));
                    isVisited[status.brokenWall][nextR][nextC] = true;
                }
            }
        }

        return -1;
    }
}
