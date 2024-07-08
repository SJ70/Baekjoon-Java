import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2828 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int basketLeft = 1;
        int basketRight = Integer.parseInt(st.nextToken());

        int result = 0;

        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            int apple = Integer.parseInt(br.readLine());

            if (apple < basketLeft) {
                int d = basketLeft - apple;
                result += d;
                basketLeft -= d;
                basketRight -= d;
            }
            if (basketRight < apple) {
                int d = apple - basketRight;
                result += d;
                basketLeft += d;
                basketRight += d;
            }
        }

        System.out.println(result);

    }

}
