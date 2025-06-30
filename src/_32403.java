import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _32403 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        List<Integer> arr = new ArrayList<>();
        for (int i=1; i<=T; i++) {
            if (T%i==0) {
                arr.add(i);
            }
        }

        int result = 0;
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            int n = Integer.parseInt(st.nextToken());
            int nearestNum = getNearestNum(n, arr);
            result += Math.abs(n - nearestNum);
        }

        System.out.println(result);
    }

    // 이분탐색 쓰면 더 빠름
    private static int getNearestNum(int n, List<Integer> arr) {
        int minDiff = Integer.MAX_VALUE;
        int result = -1;
        for (int value : arr) {
            int diff = Math.abs(n - value);
            if (diff < minDiff) {
                minDiff = diff;
                result = value;
            }
            if (diff > minDiff) {
                break;
            }
        }
        return result;
    }

}
