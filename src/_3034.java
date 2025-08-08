import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3034 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int x = W*W + H*H;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            int length = Integer.parseInt(br.readLine());
            if (length * length <= x) {
                sb.append("DA\n");
            }
            else {
                sb.append("NE\n");
            }
        }
        System.out.print(sb);
    }

}
