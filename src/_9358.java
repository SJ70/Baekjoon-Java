import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _9358 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t=1; t<=T; t++) {
            int N = Integer.parseInt(br.readLine());
            List<Integer> arr = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            while (N > 2) {
                for (int i = 0; i <= (N-1)/2; i++) {
                    int cur = arr.get(i);
                    int last = arr.get(arr.size() - 1);
                    arr.remove(arr.size() - 1);
                    if (arr.size() > i) {
                        arr.set(i, cur + last);
                    } else {
                        arr.add(cur + last);
                    }
                }
                N = arr.size();
            }
            sb.append(String.format("Case #%d: %s\n", t, arr.get(0) > arr.get(1) ? "Alice" : "Bob"));
        }
        System.out.print(sb);
    }

}
