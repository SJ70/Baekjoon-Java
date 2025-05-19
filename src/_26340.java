import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _26340 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            System.out.printf("Data set: %d %d %d\n", a, b, c);
            for (int j=0; j<c; j++) {
                if (a > b) {
                    a /= 2;
                }
                else {
                    b /= 2;
                }
            }
            System.out.printf("%d %d\n", Math.max(a, b), Math.min(a, b));
            if (i<N-1) {
                System.out.println();
            }
        }
    }

}
