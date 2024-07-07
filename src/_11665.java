import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11665 {

    private static class Cube {
        int x1, y1, z1, x2, y2, z2;

        public Cube(int x1, int y1, int z1, int x2, int y2, int z2) {
            this.x1 = x1;
            this.y1 = y1;
            this.z1 = z1;
            this.x2 = x2;
            this.y2 = y2;
            this.z2 = z2;
        }

        public Cube(Cube cube1, Cube cube2) {
            this.x1 = Math.max(cube1.x1, cube2.x1);
            this.x2 = Math.min(cube1.x2, cube2.x2);
            this.y1 = Math.max(cube1.y1, cube2.y1);
            this.y2 = Math.min(cube1.y2, cube2.y2);
            this.z1 = Math.max(cube1.z1, cube2.z1);
            this.z2 = Math.min(cube1.z2, cube2.z2);
        }

        public int getSize() {
            int dx = x2 - x1;
            int dy = y2 - y1;
            int dz = z2 - z1;
            if (dx < 0 || dy < 0 || dz < 0) {
                return 0;
            }
            return dx * dy * dz;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Cube intersection = new Cube(0, 0, 0, 1000, 1000, 1000);
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int z1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int z2 = Integer.parseInt(st.nextToken());
            Cube cube = new Cube(x1, y1, z1, x2, y2, z2);
            intersection = new Cube(intersection, cube);
        }
        System.out.println(intersection.getSize());
    }

}
