import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class _14226 {

    private static final int INF = Integer.MAX_VALUE;
    private static final int MAX_N = 1000;

    private static int N;
    private static int[][] times; // [screen][clipboard]

    private static class Coordinate {

        int screen;
        int clipboard;

        public Coordinate(int screen, int clipboard) {
            this.screen = screen;
            this.clipboard = clipboard;
        }
    }

    private static Queue<Coordinate> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        times = new int[MAX_N + 1][MAX_N + 1];
        for (int i = 0; i <= MAX_N; i++) {
            Arrays.fill(times[i], INF);
        }
        times[1][0] = 0;
        q.add(new Coordinate(1, 0));

        while (!q.isEmpty()) {

//            for (int i = 0; i <= MAX_N; i++) {
//                System.out.println(Arrays.toString(times[i]));
//            }

            Coordinate coordinate = q.poll();

            int time = times[coordinate.screen][coordinate.clipboard];

            if (coordinate.screen == N) {
                System.out.println(time);
                return;
            }

            // 1. clipboard = screen
            replaceValueAndAddQueueIfFaster(time + 1, coordinate.screen, coordinate.screen);

            // 2. screen += clipboard
            replaceValueAndAddQueueIfFaster(time + 1, coordinate.screen + coordinate.clipboard, coordinate.clipboard);

            // 3. screen--
            replaceValueAndAddQueueIfFaster(time + 1, coordinate.screen - 1, coordinate.clipboard);
        }
    }

    private static void replaceValueAndAddQueueIfFaster(int time, int screen, int clipboard) {
        if (screen < 0 || screen > MAX_N) {
            return;
        }
        if (time < times[screen][clipboard]) {
            times[screen][clipboard] = time;
            q.add(new Coordinate(screen, clipboard));
        }
    }

}
