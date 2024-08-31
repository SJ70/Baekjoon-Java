import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class _4540 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            StringTokenizer st;

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            String[] strs = br.readLine().split(" ");

            String[] result = new String[N];
            for (int m=0; m<M; m++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                result[to - 1] = strs[from - 1];
                strs[from - 1] = null;
            }

            for (int i=0; i<N; i++) {
                if (result[i] == null) {
                    for (int j=0; j<N; j++) {
                        if (strs[j] != null) {
                            result[i] = strs[j];
                            strs[j] = null;
                            break;
                        }
                    }
                }
            }

            sb.append(Arrays.stream(result).collect(Collectors.joining(" ")));
            sb.append('\n');
        }

        System.out.print(sb);
    }

}
