import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _22233 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for (int i=0; i<N; i++) {
            set.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<M; i++) {
            for (String str : br.readLine().split(",")) {
                set.remove(str);
            }
            sb.append(set.size());
            sb.append("\n");
        }

        System.out.print(sb);
    }

}
