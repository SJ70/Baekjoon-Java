import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11505 {

    private static int N;

    private static int arrLength;
    private static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int opers = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());

        arrLength = 1;
        while (arrLength < N) {
            arrLength *= 2;
        }
        arrLength *= 2;
        arr = new long[arrLength];
        for (int i=arrLength/2; i<arrLength/2+N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        for (int i=arrLength/2-1; i>=1; i--) {
            arr[i] = (arr[i*2] * arr[i*2+1]) % 1000000007;
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<opers; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            switch (a) {
                case 1 :
                    int idx = arrLength/2 + b-1;
                    arr[idx] = c;
                    while (idx > 0) {
                        arr[idx/2] = (arr[idx] * arr[idx%2==0 ? idx+1 : idx-1]) % 1000000007;
                        idx /= 2;
                    }
                    break;
                case 2 :
                    sb.append(getSum(1, b-1, (int)c-1, 0, arrLength/2 - 1));
                    sb.append('\n');
                    break;
            }
        }
        System.out.print(sb);
    }

    private static long getSum(int i, int from, int until, int currentFrom, int currentUntil) {
//        System.out.printf("%d %d %d %d %d\n", i, from, until, currentFrom, currentUntil);
        if (from > currentUntil || until < currentFrom) {
            return 1;
        }
        if (from <= currentFrom && until >= currentUntil) {
            return arr[i];
        }

        int currentMid = (currentFrom + currentUntil) / 2;
        long left = getSum(i * 2, from, until, currentFrom, currentMid);
        long right = getSum(i * 2 + 1, from, until, currentMid + 1, currentUntil);
        return (left * right) % 1000000007;
    }

}
