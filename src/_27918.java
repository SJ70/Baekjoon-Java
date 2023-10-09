import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _27918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int d = 0;
        int p = 0;

        for (int i=0; i<n; i++) {
            char winner = br.readLine().charAt(0);
            if (winner == 'D') {
                d++;
            }
            else {
                p++;
            }
            if (Math.abs(d - p) >= 2) {
                break;
            }
        }

        System.out.printf("%d:%d",d,p);
    }
}
