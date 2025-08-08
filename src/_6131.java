import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _6131 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i=1; i<=500; i++) {
            int a = i * i;
            for (int j=i+1; j<=500; j++) {
                int b = j * j;
                if (b - a == N) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }

}
