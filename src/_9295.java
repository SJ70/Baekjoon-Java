import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _9295 {

    private static final String FORMAT = "Case %d: %d\n";

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t=1; t<=T; t++) {
            int sum = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sum();
            sb.append(String.format(FORMAT, t, sum));
        }

        System.out.print(sb);

    }

}
