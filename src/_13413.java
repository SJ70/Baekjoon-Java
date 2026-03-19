import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _13413 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            int N = Integer.parseInt(br.readLine());
            String from = br.readLine();
            String to = br.readLine();
            int diffB = 0;
            int diffW = 0;
            for (int i=0; i<N; i++) {
                char fromC = from.charAt(i);
                char toC = to.charAt(i);
                if (fromC == toC) {
                    continue;
                }
                if (fromC == 'B') {
                    diffB++;
                }
                else {
                    diffW++;
                }
            }
            int result = Math.max(diffB, diffW);
            sb.append(result);
            sb.append("\n");
        }
        System.out.print(sb);
    }


}
