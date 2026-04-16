import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _6784 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] arr = new char[N];
        for (int i=0; i<N; i++) {
            arr[i] = br.readLine().charAt(0);
        }
        int result = 0;
        for (char c : arr) {
            if (c == br.readLine().charAt(0)) {
                result++;
            }
        }
        System.out.println(result);
    }

}
