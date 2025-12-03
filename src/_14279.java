import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14279 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int minResult = Integer.MAX_VALUE;
        for (int A=1; A<=c; A++) {
            for (int d=-1; d<=1; d++) {
                int B = c / A + d;
                int C = A * B;

                int da = Math.abs(A - a);
                int db = Math.abs(B - b);
                int dc = Math.abs(C - c);
                minResult = Math.min(minResult, da + db + dc);
            }
        }
        System.out.println(minResult);
    }

}
