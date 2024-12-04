import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _32710 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i=1; i<=9; i++) {
            for (int j=1; j<=9; j++) {
                if (i * j == N) {
                    System.out.println(1);
                    return;
                }
            }
        }
        System.out.println(0);
    }

}
