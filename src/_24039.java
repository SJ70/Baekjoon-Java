import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _24039 {

    private static final int N = 120;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[N];
        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false;

        for (int i=2; i<N; i++) {
            if (isPrime[i]) {
                for (int j=i+i; j<N; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i=0; i<N; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        for (int i=1; i<primes.size(); i++) {
            int prev = primes.get(i - 1);
            int curr = primes.get(i);
            int value = prev * curr;

            if (target < value) {
                System.out.println(value);
                return;
            }

        }
    }

}
