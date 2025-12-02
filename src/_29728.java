import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _29728 {

    public static void main(String[] args) throws IOException {
        boolean[] isNotPrime = new boolean[5000001];
        isNotPrime[1] = true;
        for (int i=2; i<=5000000; i++) {
            if (!isNotPrime[i]) {
                for (int j=i+i; j<=5000000; j+=i) {
                    isNotPrime[j] = true;
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println("1 0");
            return;
        }
        if (N == 2) {
            System.out.println("0 2");
            return;
        }
        if (N == 3) {
            System.out.println("0 3");
            return;
        }

        int b = 0;
        int s = 3;
        for (int i=4; i<=N; i++) {
            if (isNotPrime[i]) {
                b++;
            }
            else {
                b--;
                s+=2;
            }
        }
        System.out.printf("%d %d\n", b, s);
    }

}
