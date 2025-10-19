import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _13297 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            int result = br.readLine().length();
            sb.append(result);
            sb.append('\n');
        }
        System.out.print(sb);
    }

}
