import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _20839 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr1 = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] arr2 = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        boolean[] same = new boolean[3];
        for (int i=0; i<3; i++) {
            same[i] = arr1[i] == arr2[i];
        }
        boolean[] half = new boolean[3];
        for (int i=0; i<3; i++) {
            half[i] = arr1[i] <= arr2[i] * 2;
        }

        if (same[0] && same[1] && same[2]) {
            System.out.println('A');
            return;
        }
        if (half[0] && same[1] && same[2]) {
            System.out.println('B');
            return;
        }
        if (same[1] && same[2]) {
            System.out.println('C');
            return;
        }
        if (half[1] && same[2]) {
            System.out.println('D');
            return;
        }
        if (same[2]) {
            System.out.println('E');
            return;
        }
    }

}
