import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17072 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for (int r=0; r<R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c=0; c<C; c++) {
                int red = Integer.parseInt(st.nextToken());
                int green = Integer.parseInt(st.nextToken());
                int blue = Integer.parseInt(st.nextToken());
                int intensity = 2126 * red + 7152 * green + 722 * blue;
                if (intensity >= 2040000) {
                    sb.append('.');
                    continue;
                }
                if (intensity >= 1530000) {
                    sb.append('-');
                    continue;
                }
                if (intensity >= 1020000) {
                    sb.append('+');
                    continue;
                }
                if (intensity >= 510000) {
                    sb.append('o');
                    continue;
                }
                if (intensity >= 0) {
                    sb.append('#');
                    continue;
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

}
