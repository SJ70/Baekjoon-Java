import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _9699 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i=1; i<=N; i++) {
            int max = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).max().getAsInt();
            sb.append(String.format("Case #%d: %d\n", i, max));
        }
        System.out.print(sb);

    }

}
