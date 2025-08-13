import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _33179 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;
        for (int i=0; i<N; i++) {
            int value = Integer.parseInt(st.nextToken());
            result += value / 2;
            result += value % 2;
        }
        System.out.println(result);
    }

}
