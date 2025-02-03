import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _26560 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            String input = br.readLine();
            sb.append(input);
            if (input.charAt(input.length() - 1) != '.') {
                sb.append('.');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

}
