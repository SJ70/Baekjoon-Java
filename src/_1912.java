import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1912 {

    private static int n;
    private static int[] arr;
    private static List<Integer> sum;

    public static void main(String[] args) throws IOException {
        input();
        dp();
//        System.out.println(sum);
        System.out.println(sum.stream().max((o1, o2) -> o1 - o2).get());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private static void dp() {
        sum = new ArrayList<>();
        sum.add(arr[0]);

        for (int i=1; i<n; i++) {
            sum.add(Math.max(arr[i], sum.get(i-1) + arr[i]));
        }
    }

}
