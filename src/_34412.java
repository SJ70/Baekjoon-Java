import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _34412 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N > 12) {
            N++;
        }
        System.out.println(N);
    }

}
