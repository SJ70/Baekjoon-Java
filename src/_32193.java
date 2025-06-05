import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _32193 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int a = 0;
        int b = 0;
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a += Integer.parseInt(st.nextToken());
            b += Integer.parseInt(st.nextToken());
            sb.append(a - b).append('\n');
        }
        System.out.print(sb);
    }

}
