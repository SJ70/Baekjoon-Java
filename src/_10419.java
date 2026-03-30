import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10419 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            int d = Integer.parseInt(br.readLine());
            for (int i=100; i>=0; i--) {
                if (i + i*i <= d) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
