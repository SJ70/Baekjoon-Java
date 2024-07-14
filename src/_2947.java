import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class _2947 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] woods = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        StringBuilder sb = new StringBuilder();

        while (true) {
            boolean changed = false;
            for (int i=0; i<4; i++) {
                if (woods[i] > woods[i+1]) {
                    int tmp = woods[i];
                    woods[i] = woods[i+1];
                    woods[i+1] = tmp;
                    changed = true;
                    sb.append(Arrays.stream(woods).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
                    sb.append('\n');
                }
            }
            if (!changed) {
                break;
            }
        }

        System.out.print(sb);

    }

}
