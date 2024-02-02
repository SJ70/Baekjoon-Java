import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _10953 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++) {
            int sum = Arrays.stream(br.readLine().split(",")).mapToInt(Integer::parseInt).sum();
            sb.append(String.format("%d\n", sum));
        }

        System.out.print(sb);
    }

}
