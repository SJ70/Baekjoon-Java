import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11098 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            int N = Integer.parseInt(br.readLine());
            int maxCnt = 0;
            String str = "";
            for (int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int cnt = Integer.parseInt(st.nextToken());
                if (cnt > maxCnt) {
                    maxCnt = cnt;
                    str = st.nextToken();
                }
            }
            sb.append(str).append('\n');
        }
        System.out.print(sb);
    }

}
