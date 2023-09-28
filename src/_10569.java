import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10569 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int vortex = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());
            int area = 2 - vortex + edge;
            sb.append(area).append('\n');
        }
        System.out.print(sb);
    }
}
