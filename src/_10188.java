import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10188 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int C = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            sb.append(("X".repeat(C) + '\n').repeat(R));
            if (i<N-1) sb.append('\n');
        }
        System.out.print(sb);
    }

}
