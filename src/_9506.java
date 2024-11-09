import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class _9506 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == -1) {
                break;
            }
            List<Integer> arr = new ArrayList<>();
            for (int i=1; i<N; i++) {
                if (N % i == 0) {
                    arr.add(i);
                }
            }
            int sum = arr.stream().mapToInt(Integer::valueOf).sum();
            if (N == sum) {
                sb.append(N);
                sb.append(" = ");
                sb.append(arr.stream().map(String::valueOf).collect(Collectors.joining(" + ")));
                sb.append('\n');
            }
            else {
                sb.append(N);
                sb.append(" is NOT perfect.\n");
            }
        }
        System.out.print(sb);
    }

}
