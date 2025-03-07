import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _31907 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int r=0; r<N*3; r++) {
            for (int c=0; c<N*4; c++) {
                char value = '.';
                if (r < N && c < N) {
                    value = 'G';
                }
                else if (r >= N && r < N*2 && c >= N && c < N*2) {
                    value = 'I';
                }
                else if (r >= N && r < N*2 && c >= N*3) {
                    value = 'T';
                }
                else if (r >= N*2 && c >= N*2 && c < N*3) {
                    value = 'S';
                }
                sb.append(value);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

}
