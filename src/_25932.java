import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _25932 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            boolean mack = false;
            boolean zack = false;
            String input = br.readLine();
            sb.append(input).append('\n');
            StringTokenizer st = new StringTokenizer(input);
            for (int j=0; j<10; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 17) {
                    zack = true;
                }
                else if (value == 18) {
                    mack = true;
                }
            }
            sb.append(mack && zack ? "both" : mack ? "mack" : zack ? "zack" : "none");
            sb.append(i == N-1 ? "\n" : "\n\n");
        }

        System.out.print(sb);
    }

}
