import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _28076 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> arr = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());

        if (arr.size() == 1) {
            System.out.println(arr.get(0));
            return;
        }
        if (arr.size() == 2) {
            System.out.println(arr.get(0) + arr.get(1) - 1);
            return;
        }

        int sIdx = N/3 - 1;
        int mIdx = N/3*2 + N%3/2 - 1;
        int lIdx = N/3*3 + N%3 - 1;
        int s = arr.get(sIdx);
        int m = arr.get(mIdx);
        int l = arr.get(lIdx);

        System.out.println(s + m + l - 3);
    }

}
