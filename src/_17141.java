import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _17141 {

    private static int N;
    private static int M;
    private static int[][] map;
    private static List<Point> virusSrc;
    private static int result = Integer.MAX_VALUE;

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        virusSrc = new ArrayList<>();
        int v = 0;
        for (int r=0; r<N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c=0; c<N; c++) {
                int value = Integer.parseInt(st.nextToken());
                switch (value) {
                    case 0 :
                        map[r][c] = Integer.MAX_VALUE;
                        break;
                    case 1 :
                        map[r][c] = 0;
                        break;
                    case 2 :
                        map[r][c] = Integer.MAX_VALUE;
                        virusSrc.add(new Point(r, c));
                        v++;
                        break;
                }
            }
        }

        dfs(map, 0, 0);

        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    private static void dfs(int[][] map, int virusCnt, int virusSrcIdx) {
        if (virusCnt == M) {
            int max = 0;
            for (int r=0; r<N; r++) {
                for (int c=0; c<N; c++) {
                    if (map[r][c] == Integer.MAX_VALUE) {
                        return;
                    }
                    max = Math.max(max, map[r][c]);
                }
            }
            result = Math.min(result, max);
            return;
        }
        if (virusSrcIdx == virusSrc.size()) {
            return;
        }
        int[][] map1 = deepCopy(map);
        spread(map1, virusSrc.get(virusSrcIdx).x, virusSrc.get(virusSrcIdx).y, 0);
        dfs(map1, virusCnt + 1, virusSrcIdx + 1);

        dfs(map, virusCnt, virusSrcIdx + 1);
    }
    
    private static void spread(int[][] map, int r, int c, int value) {
        map[r][c] = value;

        if (r-1 >= 0 && map[r-1][c] > value + 1) {
            spread(map, r-1, c, value + 1);
        }
        if (c-1 >= 0 && map[r][c-1] > value + 1) {
            spread(map, r, c-1, value + 1);
        }
        if (r+1 < N && map[r+1][c] > value + 1) {
            spread(map, r+1, c, value + 1);
        }
        if (c+1 < N && map[r][c+1] > value + 1) {
            spread(map, r, c+1, value + 1);
        }
    }

    private static int[][] deepCopy(int[][] map) {
        int[][] copy = new int[N][N];
        for (int r=0; r<N; r++) {
            System.arraycopy(map[r], 0, copy[r], 0, N);
        }
        return copy;
    }

}
