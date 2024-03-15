import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3184 {

    private static final char WALL = '#';
    private static final char WOLF = 'v';
    private static final char SHEEP = 'o';
    private static final char EMPTY = '.';

    private static int R, C;
    private static char[][] map;
    private static boolean[][] visited;

    private static int currentSectionSheepCnt;
    private static int currentSectionWolvesCnt;

    private static int resultSheepCnt;
    private static int resultWolvesCnt;

    public static void main(String[] args) throws IOException {
        input();
        observe();

        System.out.printf("%d %d\n", resultSheepCnt, resultWolvesCnt);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for (int r=0; r<R; r++) {
            String str = br.readLine();
            for (int c=0; c<C; c++) {
                map[r][c] = str.charAt(c);
            }
        }
    }

    private static void observe() {
        visited = new boolean[R][C];

        for (int r=0; r<R; r++) {
            for (int c=0; c<C; c++) {

                currentSectionSheepCnt = 0;
                currentSectionWolvesCnt = 0;

                if (map[r][c] != WALL && !visited[r][c]) {
                    visitNearby(r, c);
                }

                if (currentSectionWolvesCnt >= currentSectionSheepCnt) {
                    resultWolvesCnt += currentSectionWolvesCnt;
                }
                else {
                    resultSheepCnt += currentSectionSheepCnt;
                }

            }
        }
    }

    private static int[] dr = new int[] {-1, 0, 1, 0};
    private static int[] dc = new int[] {0, 1, 0, -1};
    private static void visitNearby(int r, int c) {

        visited[r][c] = true;

        if (map[r][c] == WOLF) {
            currentSectionWolvesCnt++;
        }
        else if (map[r][c] == SHEEP) {
            currentSectionSheepCnt++;
        }

        for (int dir = 0; dir < 4; dir++) {
            int nextR = r + dr[dir];
            int nextC = c + dc[dir];

            if (nextR < 0 || nextR == R || nextC < 0 || nextC == C) {
                continue;
            }

            if (map[nextR][nextC] != WALL && !visited[nextR][nextC]) {
                visitNearby(nextR, nextC);
            }
        }
    }

}
