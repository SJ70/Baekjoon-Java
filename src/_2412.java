import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class _2412 {

    private static int holeCount;
    private static int top;
    private static Set<Hole> holes = new HashSet<>();
    private static Queue<Hole> bfsQueue = new ArrayDeque<>();

    private static class Hole {
        public final int x;
        public final int y;

        public Hole(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            Hole other = (Hole)obj;
            return x == other.x && y == other.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) throws IOException {
        init();

        int result = 0;
        bfsQueue.add(new Hole(0, 0));
        while (!bfsQueue.isEmpty()) {
            int loop = bfsQueue.size();
            for (int i=0; i<loop; i++) {
                Hole currentHole = bfsQueue.poll();
                if (currentHole.y == top) {
                    System.out.println(result);
                    return;
                }
                addQueueNextHoles(currentHole);
            }
            result++;
        }
        System.out.println(-1);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        holeCount = Integer.parseInt(st.nextToken());
        top = Integer.parseInt(st.nextToken());
        for (int i=0; i<holeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            holes.add(new Hole(x, y));
        }
    }

    private static void addQueueNextHoles(Hole currentHole) {
        int x = currentHole.x;
        int y = currentHole.y;
        for (int i=x-2; i<=x+2; i++) {
            for (int j=y-2; j<=y+2; j++) {
                Hole nextHole = new Hole(i, j);
                if (holes.contains(nextHole)) {
                    holes.remove(nextHole);
                    bfsQueue.add(nextHole);
                }
            }
        }
    }

}
