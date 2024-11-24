import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9287 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        loop: for (int t=1; t<=T; t++) {
            sb.append("Case ");
            sb.append(t);
            sb.append(": ");

            int N = Integer.parseInt(br.readLine());

            String[] values = new String[N];
            for (int i=0; i<N; i++) {
                values[i] = br.readLine();
            }

            for (int i=0; i<N; i++) {
                if (values[i].equals("000") || values[i].equals("100") || values[i].equals("001")) {
                    sb.append("Fallen\n");
                    continue loop;
                }
            }
            sb.append("Standing\n");

        }

        System.out.print(sb);
    }

}
