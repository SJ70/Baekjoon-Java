import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _25801 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] arr = new int[26];
        for (char c : str.toCharArray()) {
            arr[c-'a']++;
        }
        int odd = 0;
        int even = 0;
        for (int i : arr) {
            if (i > 0) {
                if (i % 2 == 1) {
                    odd++;
                }
                else {
                    even++;
                }
            }
        }
        if (odd == 0) {
            System.out.println(0);
            return;
        }
        if (even == 0) {
            System.out.println(1);
            return;
        }
        System.out.println("0/1");
    }

}
