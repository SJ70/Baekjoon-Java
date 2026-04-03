import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2097 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int root = (int) Math.sqrt(N);
        int r = root;
        int c = (N + root - 1) / root;
        int result = 2 * (r + c - 2);
        result = Math.max(result, 4);
        System.out.println(result);
    }

}
