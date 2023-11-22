import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class _30679 {

    private static int R;
    private static int C;
    private static int[][] MAP;

    private static Boolean[][][] canEscape;
    private static boolean[][][] visited;

    private static int resultCount;
    private static Set<Integer> resultRows = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        init();
        dp();
        System.out.println(resultCount);
        System.out.println(resultRows.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        MAP = new int[R][C];

        for (int r = 0; r < R; r++) {
            MAP[r] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }

    private static void dp() {
        canEscape = new Boolean[4][R][C];
        visited = new boolean[4][R][C];
        for (int r = 0; r < R; r++) {
            boolean canEscapeHere = tryEscape(0, r, 0);
            if (!canEscapeHere) {
                resultCount++;
                resultRows.add(r + 1);
            }
        }
    }

    // 0 : 오른쪽
    private static int[] DR = {0, 1, 0, -1};
    private static int[] DC = {1, 0, -1, 0};

    private static boolean tryEscape(int dir, int r, int c) {
        // 탈출
        if (r < 0 || r >= R || c < 0 || c >= C) {
            return true;
        }

        if (visited[dir][r][c]) {
            if (canEscape[dir][r][c] == null) {
                canEscape[dir][r][c] = false;
                return false;
            }
            return canEscape[dir][r][c];
        }

        visited[dir][r][c] = true;
        if (canEscape[dir][r][c] != null) {
            return canEscape[dir][r][c];
        }

        int value = MAP[r][c];
        int nextR = r + DR[dir] * value;
        int nextC = c + DC[dir] * value;
        int nextDir = (dir + 1) % 4;
        canEscape[dir][r][c] = tryEscape(nextDir, nextR, nextC);
        return canEscape[dir][r][c];
    }

}
