import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _30454 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] arr = new int[1000];
        int maxValue = 0;
        for (int i=0; i<N; i++) {
            String str = br.readLine();
            char prev = '0';
            int value = 0;
            for (char c : str.toCharArray()) {
                if (c == '0' && prev == '1') {
                    value++;
                }
                prev = c;
            }
            if (prev == '1') {
                value++;
            }

            arr[value]++;
            if (value > maxValue) {
                maxValue = value;
            }
        }
        System.out.printf("%d %d\n", maxValue, arr[maxValue]);
    }

}
