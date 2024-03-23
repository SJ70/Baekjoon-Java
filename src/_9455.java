import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _9455 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int[] stackPerCol = new int[C];

            int result = 0;
            for (int r=0; r<R; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c=0; c<C; c++) {
                    int value = Integer.parseInt(st.nextToken());
                    if (value == 0) {
                        continue;
                    }
                    result += R - 1 - r - (stackPerCol[c]++);
                }
            }
            sb.append(result);
            sb.append('\n');
        }

        System.out.print(sb);
    }

}
