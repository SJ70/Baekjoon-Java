import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _3059 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            boolean[] arr = new boolean[26];
            String str = br.readLine();
            for (char c : str.toCharArray()) {
                arr[c - 'A'] = true;
            }
            int result = 0;
            for (int i=0; i<26; i++) {
                if (!arr[i]) {
                    result += 65 + i;
                }
            }
            System.out.println(result);
        }
    }

}
