import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9494 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            int result = 0;
            for (int i=0; i<N; i++) {
                String str = br.readLine();
                for (int j=result; j<str.length(); j++) {
                    if (str.charAt(j) == ' ') {
                        result = j;
                        break;
                    }
                    result = str.length();
                }
            }
            sb.append(result + 1);
            sb.append('\n');
        }
        System.out.print(sb);

    }

}
