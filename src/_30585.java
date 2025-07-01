import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _30585 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int one = 0;
        for (int r=0; r<R; r++) {
            one += Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .sum();
        }
        int zero = R * C - one;
        System.out.println(Math.min(one, zero));
    }

}
