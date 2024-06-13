import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1380 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t=1; true; t++) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            String[] names = new String[N];
            for (int i=0; i<N; i++) {
                names[i] = br.readLine();
            }
            boolean[] taken = new boolean[N];
            for (int i=0; i<N*2-1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken()) - 1;
                taken[idx] = !taken[idx];
            }
            for (int i=0; i<N; i++) {
                if (taken[i]) {
                    sb.append(t).append(' ').append(names[i]).append('\n');
                    break;
                }
            }
        }

        System.out.print(sb);

    }

}
