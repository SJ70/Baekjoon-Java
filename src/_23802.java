import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _23802 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.print(("@".repeat(5 * N) + '\n').repeat(N));
        System.out.print(("@".repeat(N) + '\n').repeat(4 * N));
    }

}
