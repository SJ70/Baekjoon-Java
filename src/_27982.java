import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class _27982 {

    private static int N;
    private static boolean[][][] isFilled;
    private static Queue<int[]> Q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        isFilled = new boolean[N+1][N+1][N+1];

        int M = Integer.parseInt(st.nextToken());
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            isFilled[x][y][z] = true;
            Q.add(new int[] {x, y, z});
        }

        int result = 0;
        while (!Q.isEmpty()) {
            int[] pos = Q.poll();
            if (isFilledNearby(pos[0], pos[1], pos[2])) {
                result++;
            }
        }

        System.out.println(result);

    }

    private static boolean isFilledNearby(int x, int y, int z) {
        if (x <= 1 || x >= N || y <= 1 || y >= N || z <= 1 || z >= N) {
            return false;
        }
        return isFilled[x-1][y][z] && isFilled[x+1][y][z] && isFilled[x][y-1][z] && isFilled[x][y+1][z] && isFilled[x][y][z-1] && isFilled[x][y][z+1];
    }

}
