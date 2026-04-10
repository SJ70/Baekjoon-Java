import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class _24431 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int F = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int result = 0;
            Set<String> set = new HashSet<>();
            for (int i=0; i<N; i++) {
                String str = st.nextToken().substring(L - F);
                if (set.contains(str)) {
                    set.remove(str);
                    result++;
                }
                else {
                    set.add(str);
                }
            }
            sb.append(result);
            sb.append('\n');
        }
        System.out.print(sb);
    }

}
