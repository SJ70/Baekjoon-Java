import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _19845 {

    private static int N, Q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int self = arr[y-1] >= x ? 1 : 0;
            int right = Math.max(arr[y-1] - x, 0);
            int bottom = Math.max(bs(arr, x, 0, N - 1) + 1 - y, 0);
            int result = self + right + bottom;
//            System.out.printf("(%d,%d) : %d %d %d, %d\n", y, x, self, right, bottom, result);
            sb.append(result);
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private static int bs(int[] arr, int target, int left, int right) {
        if (arr[left] < target) {
            return left;
        }
        if (arr[right] >= target) {
            return right;
        }
        if (left + 1 == right) {
            return left;
        }
        int mid = (left + right) / 2;
        if (arr[mid] >= target) {
            return bs(arr, target, mid, right);
        }
        else {
            return bs(arr, target, left, mid);
        }
    }

}
