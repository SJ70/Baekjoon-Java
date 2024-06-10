import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _26731 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        boolean[] arr = new boolean[26];

        for (char c : str.toCharArray()) {
            int idx = c - 'A';
            arr[idx] = true;
        }

        for (int i=0; i<26; i++) {
            if (!arr[i]) {
                System.out.println((char)('A' + i));
                return;
            }
        }
    }

}
