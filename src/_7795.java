import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _7795 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            br.readLine();
            int[] a = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();
            int[] b = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();
            System.out.println(getBiggerCnt(a, b));
        }
    }

    private static int getBiggerCnt(int[] a, int[] b) {
        int A = a.length;
        int B = b.length;
        int cnt = 0;
        for (int i=0; i<A; i++) {
            int j=0;
            while (true) {
                if (j == B || a[i] <= b[j]) {
                    cnt += j;
                    break;
                }
                j++;
            }
        }
        return cnt;
    }

}
