import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16943 {

    private static int N;
    private static int[] counts = new int[10];
    private static int until;

    private static Integer result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String from = st.nextToken();
        until = Integer.parseInt(st.nextToken());

        N = from.length();
        for (char c : from.toCharArray()) {
            counts[c-'0']++;
        }

        bt(0, 0);

        if (result == null) {
            System.out.println(-1);
        }
        else {
            System.out.println(result);
        }
    }

    private static void bt(int value, int d) {
        if (result != null) {
            return;
        }
        if (d == N) {
            if (value < until) {
                result = value;
                return;
            }
        }
        for (int i=9; i>=0; i--) {
            if (i==0 && d==0) {
                continue;
            }
            if (counts[i] > 0) {
                counts[i]--;
                bt(value*10+i, d+1);
                counts[i]++;
            }
        }
    }

}
