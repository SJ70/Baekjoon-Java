import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class _2693 {

    private static final int N = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i=0; i<T; i++) {
            List<Integer> arr = Arrays.stream(br.readLine().split(" ")).map(Integer::valueOf).sorted(Collections.reverseOrder()).collect(Collectors.toList());
            sb.append(arr.get(N - 1)).append('\n');
        }

        System.out.print(sb);
    }
}
