import java.io.*;
import java.util.*;

public class _6087 {

    private static class Position {
        public int r;
        public int c;

        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public boolean equals(Position p) {
            return r == p.r && c == p.c;
        }
    }

    private static int height;
    private static int width;

    private static char[][] map;
    private static boolean[][][] visited;   // dir, r, c

    private static final char SPACE = '.';
    private static final char WALL = '*';
    private static final char TARGET = 'C';

    private static List<Position> targets = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        int resultTime = bfs();
        int mirrorCount = resultTime - 1;
        System.out.println(mirrorCount);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());

        map = new char[height][width];

        for (int r=0; r<height; r++) {
            String input = br.readLine();
            for (int c=0; c<width; c++) {
                char value = input.charAt(c);
                if (value == TARGET) {
                    targets.add(new Position(r, c));
                }
                map[r][c] = value;
            }
        }
    }

    private static int[] dr = {0,1,0,-1};
    private static int[] dc = {1,0,-1,0};

    private static int bfs() {
        Queue<Position> q = new ArrayDeque<>();
        visited = new boolean[4][height][width];

        Position start = targets.get(0);
        Position destination = targets.get(1);

        q.add(start);

        int time = 0;

        while (!q.isEmpty()) {

            // 시간을 재기 위해 큐 사이즈만큼 돌며 time++
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {

                Position pos = q.poll();

                if (pos.equals(destination)) {
                    return time;
                }

                for (int dir = 0; dir < 4; dir++) {

                    int r = pos.r;
                    int c = pos.c;

                    // 같은 방향으로 계속 나아가며 큐에 추가
                    while (true) {
                        r += dr[dir];
                        c += dc[dir];
                        if (!canVisit(dir, r, c)) {
                            break;
                        }
                        q.add(new Position(r, c));
                        visited[dir][r][c] = true;
                    }
                }

            }
            time++;
        }
        return -1;
    }

    private static boolean canVisit(int dir, int r, int c) {
        return (r >= 0 && r < height && c >= 0 && c < width && !visited[dir][r][c] && map[r][c] != WALL);
    }
}
