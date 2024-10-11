import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class _11680 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + M + 1];
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=M; j++) {
                arr[i+j]++;
            }
        }
        List<Integer> result = new ArrayList<>();
        int maxValue = -1;
        for (int i=0; i<=N+M; i++) {
            if (arr[i] > maxValue) {
                result = new ArrayList<>();
                maxValue = arr[i];
            }
            if (arr[i] == maxValue) {
                result.add(i);
            }
        }
        System.out.print(result.stream().map(String::valueOf).collect(Collectors.joining("\n")));
    }

}
