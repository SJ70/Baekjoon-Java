import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2997 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        int diff1 = arr[1] - arr[0];
        int diff2 = arr[2] - arr[1];
        if (diff1 == diff2) {
            System.out.println(arr[2] + diff2);
            return;
        }
        if (diff1 > diff2) {
            System.out.println(arr[0] + diff2);
            return;
        }
        if (diff1 < diff2) {
            System.out.println(arr[1] + diff1);
            return;
        }
    }

}
