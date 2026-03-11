import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _20437 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            String str = br.readLine();
            int N = Integer.parseInt(br.readLine());

            List<Integer>[] alphabets = new ArrayList[26];
            for (int i=0; i<26; i++) {
                alphabets[i] = new ArrayList<>();
            }
            for (int i=0; i<str.length(); i++) {
                int idx = str.charAt(i) - 'a';
                alphabets[idx].add(i);
            }
            int shortest = Integer.MAX_VALUE;
            int longest = 0;
            for (List<Integer> alphabet : alphabets) {
                for (int i=0; i+N-1<alphabet.size(); i++) {
                    int length = alphabet.get(i+N-1) - alphabet.get(i) + 1;
                    shortest = Math.min(shortest, length);
                    longest = Math.max(longest, length);
                }
            }
            if (shortest == Integer.MAX_VALUE) {
                sb.append("-1\n");
            }
            else {
                sb.append(shortest);
                sb.append(' ');
                sb.append(longest);
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }

}
