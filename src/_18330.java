import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _18330 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        System.out.println(Math.min(N, 60 + K) * 1500 + Math.max(0, N - 60 - K) * 3000);
    }

}
