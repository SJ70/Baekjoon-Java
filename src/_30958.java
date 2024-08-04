import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _30958 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int[] counts = new int[26];
        for (char c : str.toCharArray()) {
            if (c < 'a' || c > 'z') {
                continue;
            }
            int idx = c - 'a';
            counts[idx]++;
        }

        int maxCount = Arrays.stream(counts).max().getAsInt();
        System.out.println(maxCount);

    }

}
