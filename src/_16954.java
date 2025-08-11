import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class _16954 {

    private static boolean[][] isWall = new boolean[8][8];
    private static boolean[][] visited = new boolean[8][8];
    private static Queue<int[]> queue = new ArrayDeque<>();

    private static final int[] drs = {-1, 0, 1};
    private static final int[] dcs = {-1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int r=0; r<8; r++) {
            String str = br.readLine();
            for (int c=0; c<8; c++) {
                isWall[r][c] = str.charAt(c) == '#';
            }
        }

        queue.add(new int[] {7, 0});

        while (!queue.isEmpty()) {
            visited = new boolean[8][8];

            int loopCnt = queue.size();

            // player moves
            for (int i=0; i<loopCnt && !queue.isEmpty(); i++) {

                int[] data = queue.poll();
                int r = data[0];
                int c = data[1];

                if (isWall[r][c]) {
                    continue;
                }

                queue.add(new int[] {r, c});

                for (int dr : drs) {
                    int nextR = r + dr;
                    if (nextR < 0 || nextR > 7) {
                        continue;
                    }
                    for (int dc : dcs) {
                        int nextC = c + dc;
                        if (nextC < 0 || nextC > 7) {
                            continue;
                        }
                        if (!visited[nextR][nextC] && !isWall[nextR][nextC]) {
                            if (nextR == 0 && nextC == 7) {
                                System.out.println(1);
                                return;
                            }
                            queue.add(new int[] {nextR, nextC});
                            visited[nextR][nextC] = true;
                        }
                    }
                }
            }

            // walls move
            for (int r=7; r>=1; r--) {
                isWall[r] = isWall[r-1];
            }
            isWall[0] = new boolean[8];
        }

        System.out.println(0);
    }

}
