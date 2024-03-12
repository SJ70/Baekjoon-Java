import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1915 {

    private static int R, C;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        input();
        prefixSum();
        System.out.println(getMaxSize());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[R+1][C+1];
        for (int r=1; r<=R; r++) {
            String str = br.readLine();
            for (int c=1; c<=C; c++) {
                arr[r][c] = str.charAt(c-1) - '0';
            }
        }
    }

    private static void prefixSum() {
        for (int r=1; r<=R; r++) {
            for (int c=1; c<=C; c++) {
                arr[r][c] += arr[r-1][c];
            }
        }
        for (int r=1; r<=R; r++) {
            for (int c=1; c<=C; c++) {
                arr[r][c] += arr[r][c-1];
//                System.out.printf("%3d", arr[r][c]);
            }
//            System.out.println();
        }
    }

    private static int getMaxSize() {
        int length = 0;
        for (int r=1; r<=R; r++) {
            for (int c=1; c<=C; c++) {
                for (int l=length; r+l<=R && c+l<=C; l++) {
                    if (isSquare(r, c, l + 1)) {
                        length++;
                    }
                    else {
                        break;
                    }
                }
            }
        }
        return length * length;
    }

    private static boolean isSquare(int r, int c, int length) {
        return getSize(r, c, length) == length * length;
    }

    private static int getSize(int r, int c, int length) {
        return arr[r-1+length][c-1+length] - arr[r-1][c-1+length] - arr[r-1+length][c-1] + arr[r-1][c-1];
    }

}
