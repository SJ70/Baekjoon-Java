import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _5612 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int carsCnt = Integer.parseInt(br.readLine());
        int result = carsCnt;
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            carsCnt += Integer.parseInt(st.nextToken());
            carsCnt -= Integer.parseInt(st.nextToken());
            if (carsCnt < 0) {
                System.out.println(0);
                return;
            }
            result = Math.max(result, carsCnt);
        }
        System.out.println(result);

    }

}
