import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _35262 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String str = br.readLine();

        int zeros = 0;
        for (int i=0; i<N; i++) {
            if (str.charAt(i) == '0') {
                zeros++;
                if (zeros == M) {
                    System.out.println(0);
                    return;
                }
            }
            else {
                zeros = 0;
            }
        }
        System.out.println(1);
    }

}
