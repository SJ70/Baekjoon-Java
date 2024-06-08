import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _11024 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<T; i++) {
            int sum = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sum();
            sb.append(sum).append('\n');
        }
        System.out.print(sb);

    }

}
