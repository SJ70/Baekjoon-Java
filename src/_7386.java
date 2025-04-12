import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _7386 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String encoded = br.readLine();
        String decoded = br.readLine();

        int[] decodedAlphabets = new int[26];
        for (char c : decoded.toCharArray()) {
            decodedAlphabets[c-'A']++;
        }
        Arrays.sort(decodedAlphabets);

        int[] encodedAlphabets = new int[26];
        for (char c : encoded.toCharArray()) {
            encodedAlphabets[c-'A']++;
        }
        Arrays.sort(encodedAlphabets);

        for (int i=0; i<26; i++) {
            if (decodedAlphabets[i] != encodedAlphabets[i]) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");

    }

}
