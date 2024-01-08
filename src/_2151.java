import java.io.*;
import java.util.*;

public class _2151 {

    private static final char WALL = '*';
    private static final char ENTRANCE = '#';
    private static final char EMPTY = '.';
    private static final char PUT_ABLE = '!';

    private static int n;
    private static char[][] map;
    private static boolean[][][] visited;
    private static List<Coordinate> entrances = new ArrayList<>();
    private static Queue<Coordinate> bfsQ = new ArrayDeque<>();

    private static class Coordinate {
        int r, c;

        public Coordinate(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        init();

        Coordinate start = entrances.get(0);
        for (int i=0; i<4; i++) {
            visited[start.r][start.c][i] = true;
        }
        bfsQ.add(start);

        int cnt = -1;
        while (!bfsQ.isEmpty()) {
            cnt++;
            int loop = bfsQ.size();
            for (int i=0; i<loop && !bfsQ.isEmpty(); i++) {
                observe(bfsQ.poll());
            }
        }
        System.out.println(cnt);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        visited = new boolean[n][n][4];
        for (int r=0; r<n; r++) {
            String str = br.readLine();
            for (int c=0; c<n; c++) {
                map[r][c] = str.charAt(c);
                if (map[r][c] == ENTRANCE) {
                    entrances.add(new Coordinate(r, c));
                }
            }
        }
    }

    private static int[] dr = {-1, 0, 1, 0};
    private static int[] dc = {0, 1, 0, -1};
    private static void observe(Coordinate coordinate) {
        int r = coordinate.r;
        int c = coordinate.c;

        for (int dir = 0; dir < 4; dir++) {
            int nextR = r + dr[dir];
            int nextC = c + dc[dir];
            while (nextR >= 0 && nextR < n && nextC >= 0 && nextC < n && map[nextR][nextC] != WALL && !visited[nextR][nextC][dir]) {
                visited[nextR][nextC][dir] = true;
                visited[nextR][nextC][(dir + 2) % 4] = true;

                if (map[nextR][nextC] == ENTRANCE) {
                    bfsQ.clear();
                    return;
                }

                if (map[nextR][nextC] == PUT_ABLE) {
                    bfsQ.add(new Coordinate(nextR, nextC));
                }

                nextR += dr[dir];
                nextC += dc[dir];
            }
        }
    }

}
