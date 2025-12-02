import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _31423 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] values = new String[N];
        for (int i=0; i<N; i++) {
            values[i] = br.readLine();
        }
        Integer[] heads = new Integer[N];
        Integer[] tails = new Integer[N];
        Integer[] lastTails = new Integer[N];
        for (int i=0; i<N; i++) {
            lastTails[i] = i;
        }
        for (int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            tails[lastTails[a]] = b;
            lastTails[a] = lastTails[b];
            heads[b] = a;
        }
        for (int i=0; i<N; i++) {
            if (heads[i] == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(values[i]);
                while (tails[i] != null) {
                    i = tails[i];
                    sb.append(values[i]);
                }
                System.out.println(sb);
                return;
            }
        }
    }

}
