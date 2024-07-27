import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _10384 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i=1; i<=N; i++) {
            int[] used = new int[26];
            char[] input = br.readLine().toLowerCase().toCharArray();
            for (char c : input) {
                if (c >= 'a' && c <= 'z') {
                    used[c - 'a']++;
                }
            }
            int min = Arrays.stream(used).min().getAsInt();
            sb.append("Case " + i + ": ");
            switch (min) {
                case 0 : sb.append("Not a pangram");        break;
                case 1 : sb.append("Pangram!");             break;
                case 2 : sb.append("Double pangram!!");     break;
                default: sb.append("Triple pangram!!!");    break;
            }
            sb.append("\n");
        }
        System.out.print(sb);

    }

}
