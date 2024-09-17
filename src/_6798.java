import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class _6798 {

    private static final int[][] KNIGHT_MOVES = {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int startR = Integer.parseInt(st.nextToken());
        int startC = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int endR = Integer.parseInt(st.nextToken());
        int endC = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{startR, startC, 0});

        while (true) {
            int r = q.peek()[0];
            int c = q.peek()[1];
            int time = q.poll()[2];
            if (r == endR && c == endC) {
                System.out.println(time);
                return;
            }
            for (int[] move : KNIGHT_MOVES) {
                int nextR = r + move[0];
                int nextC = c + move[1];
                if (nextR < 1 || nextR > 8 || nextC < 1 || nextC > 8) {
                    continue;
                }
                q.add(new int[] {nextR, nextC, time + 1});
            }
        }

    }

}
