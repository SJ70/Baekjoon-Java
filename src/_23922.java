import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _23922 {

    private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i=0; i<t; i++) {
            sb.append("Case #" + (i+1) + ": " + solve() + '\n');
        }
        System.out.print(sb);
    }

    private static long solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        long[][] matrix = new long[n][n];
        for (int r=0; r<n; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c=0; c<n; c++) {
                matrix[r][c] = Long.parseLong(st.nextToken());
            }
        }

        int dirCount = 2 * n - 1;
        long[] sumPerDir = new long[dirCount];
        for (int r=0; r<n; r++) {
            for (int c=0; c<n; c++) {
                int dirIndex = n - 1 - r + c;
                sumPerDir[dirIndex] += matrix[r][c];
            }
        }

        return Arrays.stream(sumPerDir).max().orElseThrow(() -> new IllegalStateException());
    }
}
