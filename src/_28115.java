import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class _28115 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i=2; i<N; i++) {
            int diff1 = arr[i-2] - arr[i-1];
            int diff2 = arr[i-1] - arr[i];
            if (diff1 != diff2) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
        System.out.println(Arrays.stream(arr).map(n -> n*2).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
        System.out.println(Arrays.stream(arr).map(n -> -n).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }
}
