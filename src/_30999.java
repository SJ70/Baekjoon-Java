import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _30999 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int result = 0;
        for (int r=0; r<R; r++) {
            int acceptCnt = Arrays.stream(br.readLine().split("")).mapToInt(value -> value.equals("O") ? 1 : 0).sum();
            if ( acceptCnt >= (C+1)/2 ) {
                result++;
            }
        }
        System.out.println(result);

    }

}
