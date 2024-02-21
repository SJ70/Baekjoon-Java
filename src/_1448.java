import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class _1448 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Integer[] lengths = new Integer[n];
        for (int i = 0; i < n; i++) {
            lengths[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(lengths, Collections.reverseOrder());

        for (int i = 0; i + 2 < n; i++) {
            if (lengths[i] < lengths[i + 1] + lengths[i + 2]) {
                System.out.println(lengths[i] + lengths[i + 1] + lengths[i + 2]);
                return;
            }
        }
        System.out.println(-1);
    }

}
