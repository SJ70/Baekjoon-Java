import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _29738 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t=1; t<=T; t++) {
            sb.append("Case #").append(t).append(": ");
            int value = Integer.parseInt(br.readLine());
            if (value <= 25) {
                sb.append("World Finals\n");
                continue;
            }
            sb.append("Round ");
            if (value <= 1000) {
                sb.append("3");
            }
            else if (value <= 4500) {
                sb.append("2");
            }
            else {
                sb.append("1");
            }
            sb.append("\n");
        }

        System.out.print(sb);

    }

}
