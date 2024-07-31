import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _26561 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long from = Long.parseLong(st.nextToken());
            long time = Long.parseLong(st.nextToken());
            long die = time / 7;
            long birth = time / 4;
            long result = from - die + birth;
            sb.append(result).append('\n');
        }
        System.out.print(sb);

    }

}
