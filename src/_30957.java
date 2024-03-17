import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _30957 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int b = 0, s = 0, a = 0;
        for (char c : str.toCharArray()) {
            if (c == 'B') b++;
            if (c == 'S') s++;
            if (c == 'A') a++;
        }
        int max = Math.max(b, Math.max(s, a));
        if (b == s && s == a) {
            System.out.println("SCU");
            return;
        }
        StringBuilder sb = new StringBuilder();
        if (b == max) {
            sb.append('B');
        }
        if (s == max) {
            sb.append('S');
        }
        if (a == max) {
            sb.append('A');
        }
        System.out.println(sb);

    }

}
