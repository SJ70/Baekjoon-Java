import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class _5217 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(String.format("Pairs for %d:", N));

            List<Integer> arr = new ArrayList<>();
            for (int i=1; i<(N+1)/2; i++) {
                arr.add(i);
            }
            sb.append(
                    arr.stream()
                            .map(value -> String.format(" %d %d", value, N-value))
                            .collect(Collectors.joining(","))
            );

            sb.append('\n');
        }
        System.out.print(sb);
    }

}
