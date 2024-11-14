import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10174 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        loop: for (int t=0; t<T; t++) {
            String str = br.readLine();
            str = str.toLowerCase();
            int length = str.length();
            for (int i=0; i<length/2; i++) {
                if (str.charAt(i) != str.charAt(length - 1 - i)) {
                    sb.append("No\n");
                    continue loop;
                }
            }
            sb.append("Yes\n");
        }

        System.out.print(sb);
    }

}
