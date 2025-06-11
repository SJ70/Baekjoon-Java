import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _15372 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            long N = Long.parseLong(br.readLine());
            sb.append(N * N);
            sb.append('\n');
        }
        System.out.print(sb);
    }

}
