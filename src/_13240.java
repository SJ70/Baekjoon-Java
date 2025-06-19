import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _13240 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for (int r=0; r<R; r++) {
            for (int c=0; c<C; c++) {
                sb.append(((r + c) % 2 == 0) ? '*' : '.');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

}
