import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _3778 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            String a = br.readLine();
            String b = br.readLine();
            int[] arr = new int[26];
            for (char c : a.toCharArray()) {
                arr[c - 'a']++;
            }
            for (char c : b.toCharArray()) {
                arr[c - 'a']--;
            }
            int result = Arrays.stream(arr).map(Math::abs).sum();
            String resultStr = String.format("Case #%d: %d\n", t, result);
            sb.append(resultStr);
        }
        System.out.print(sb);
    }

}
