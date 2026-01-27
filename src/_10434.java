import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10434 {

    private static boolean[] isNotPrime = new boolean[10001];
    private static Boolean[] isHappyPrime = new Boolean[10001];

    public static void main(String[] args) throws IOException {

        isNotPrime[0] = isNotPrime[1] = true;
        for (int i=2; i<=10000; i++) {
            if (!isNotPrime[i]) {
                for (int j=i*2; j<10001; j+=i) {
                    isNotPrime[j] = true;
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            sb.append(String.format("%d %d %s\n", i, n, isHappyWrapper(n) ? "YES" : "NO"));
        }
        System.out.print(sb);
    }

    private static Boolean isHappyWrapper(int n) {
        if (isNotPrime[n]) {
            return false;
        }
        boolean[] visited = new boolean[10001];
        return isHappy(n, visited);
    }

    private static Boolean isHappy(int n, boolean[] visited) {
        if (visited[n]) {
            return false;
        }
        visited[n] = true;

        if (n == 1) {
            return true;
        }

        if (isHappyPrime[n] != null) {
            return isHappyPrime[n];
        }

        int tmp = n;
        int next = 0;
        while (tmp > 0) {
            next += (tmp % 10) * (tmp % 10);
            tmp /= 10;
        }
        isHappyPrime[n] = isHappy(next, visited);
        return isHappyPrime[n];
    }

}
