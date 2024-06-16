import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _31867 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int odd = 0;
        int even = 0;
        for (char c : br.readLine().toCharArray()) {
            int value = c - '0';
            if (value%2==0) {
                even++;
            }
            else {
                odd++;
            }
        }

        if (odd == even) {
            System.out.println(-1);
        }
        else if (odd > even) {
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }

    }

}
