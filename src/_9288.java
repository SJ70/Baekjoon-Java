import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9288 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t=1; t<=T; t++) {
            int N = Integer.parseInt(br.readLine());
            sb.append("Case ").append(t).append(":\n");
            for (int a=1; a<=6; a++) {
                for (int b=a; b<=6; b++) {
                    if (a + b == N) {
                        sb.append("(").append(a).append(",").append(b).append(")\n");
                    }
                }
            }
        }

        System.out.print(sb);
    }

}
