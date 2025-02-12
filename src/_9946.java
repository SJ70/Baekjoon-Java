import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9946 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        loop: for (int i=1; true; i++) {
            String A = br.readLine();
            String B = br.readLine();
            if (A.equals("END") && B.equals("END")) {
                break;
            }
            int[] arr = new int[26];
            for (char c : A.toCharArray()) {
                arr[c - 'a']++;
            }
            for (char c : B.toCharArray()) {
                arr[c - 'a']--;
            }
            for (int cnt : arr) {
                if (cnt != 0) {
                    System.out.printf("Case %d: different\n", i);
                    continue loop;
                }
            }
            System.out.printf("Case %d: same\n", i);
        }
    }

}
