import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _33612 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int y = 2024;
        int m = 8 + (N - 1) * 7;
        y += (m - 1) / 12;
        m = ((m - 1) % 12) + 1;
        System.out.printf("%d %d\n", y, m);
    }

}
