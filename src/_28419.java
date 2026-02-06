import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _28419 {

    public static void main(String[] args) throws IOException {
        long odd = 0;
        long even = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            int value = Integer.parseInt(st.nextToken());
            if (i % 2 == 0) {
                odd += value;
            } else {
                even += value;
            }
        }

        if (N == 3 && odd > even) {
            System.out.println(-1);
            return;
        }
        System.out.println(Math.abs(odd - even));
    }

}
