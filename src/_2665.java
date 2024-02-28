import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class _2665 {

    private static class State implements Comparable<State>{
        int r, c;
        int breakWallCnt;

        public State(int r, int c, int breakWallCnt) {
            this.r = r;
            this.c = c;
            this.breakWallCnt = breakWallCnt;
        }

        public int compareTo(State s) {
            return breakWallCnt - s.breakWallCnt;
        }
    }

    private static int N;
    private static boolean[][] isEmpty;

    private static PriorityQueue<State> pq = new PriorityQueue<>();
    private static int[][] breakWallCnts;

    private static int[] dr = new int[] {-1,0,1,0};
    private static int[] dc = new int[] {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        input();
        bfs();
        System.out.println(breakWallCnts[N-1][N-1]);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        isEmpty = new boolean[N][N];
        for (int r=0; r<N; r++) {
            String str = br.readLine();
            for (int c=0; c<N; c++) {
                isEmpty[r][c] = (str.charAt(c) == '1');
            }
        }
    }

    private static void bfs() {
        breakWallCnts = new int[N][N];
        for (int[] arr : breakWallCnts) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        pq.add(new State(0, 0, 0));
        breakWallCnts[0][0] = 0;

        while (!pq.isEmpty()) {
            State state = pq.poll();

            for (int dir=0; dir<4; dir++) {
                int r = state.r + dr[dir];
                int c = state.c + dc[dir];

                if (r < 0 || r == N || c < 0 || c == N) {
                    continue;
                }

                int breakWallCnt = state.breakWallCnt + (isEmpty[r][c] ? 0 : 1);

                if (breakWallCnts[r][c] > breakWallCnt) {
                    breakWallCnts[r][c] = breakWallCnt;
                    if (r==N-1 && c==N-1) {
                        return;
                    }
                    pq.add(new State(r, c, breakWallCnt));
                }
            }
        }
    }

}
