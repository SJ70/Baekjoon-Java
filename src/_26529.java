import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _26529 {

    public static void main(String[] args) throws IOException {

        int N = 45;
        long[] arr = new long[N+1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i=2; i<=45; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t=0; t<T; t++) {
            sb.append(arr[Integer.parseInt(br.readLine())]).append('\n');
        }

        System.out.print(sb);


    }

}
