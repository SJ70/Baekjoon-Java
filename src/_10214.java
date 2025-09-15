import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10214 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int t=0; t<T; t++) {
            int y = 0;
            int k = 0;
            for (int i=0; i<9; i++) {
                st = new StringTokenizer(br.readLine());
                y += Integer.parseInt(st.nextToken());
                k += Integer.parseInt(st.nextToken());
            }
            System.out.println(y == k ? "Draw" : y > k ? "Yonsei" : "Korea");
        }
    }

}
