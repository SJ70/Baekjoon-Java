import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2669 {

    private static class Square {
        int r1, c1, r2, c2;

        public Square(int[] arr) {
            r1 = arr[0];
            c1 = arr[1];
            r2 = arr[2];
            c2 = arr[3];
        }

        private boolean contains(int r1, int c1, int r2, int c2) {
            return this.r1 <= r1 && this.c1 <= c1 && this.r2 >= r2 && this.c2 >= c2;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Square[] squares = new Square[4];
        for (int i=0; i<4; i++) {
            squares[i] = new Square(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray());
        }

        int result = 0;
        for (int r=0; r+1<=100; r++) {
            for (int c=0; c+1<=100; c++) {
                for (Square s : squares) {
                    if (s.contains(r, c, r+1, c+1)) {
                        result++;
                        break;
                    }
                }
            }
        }
        System.out.println(result);

    }

}
