import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17496 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int t = 0;
        int result = 0;
        for (int i=1; i<=N; i++) {
            t++;
            if (t==T+1) {
                t=1;
                result += C * P;
            }
        }
        System.out.println(result);
    }

}
