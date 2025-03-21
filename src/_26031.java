import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _26031 {

    private static List<Long> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            long value = Long.parseLong(st.nextToken());
            int i = arr.size();

            // 비었다면 삽입
            if (arr.isEmpty()) {
                arr.add(value);
                continue;
            }

            // 이전 값과 같은 값은 무조건 비허용
            if (arr.get(i-1) == value) {
                continue;
            }

            // 2번째 값은 1번째 값과 다르다면 무조건 삽입
            if (arr.size() == 1) {
                arr.add(value);
                continue;
            }

            // 상향 생략
            if (arr.get(i-2) < arr.get(i-1) && arr.get(i-1) < value) {
                arr.set(i-1, value);
                continue;
            }

            // 하향 생략
            if (arr.get(i-2) > arr.get(i-1) && arr.get(i-1) > value) {
                arr.set(i-1, value);
                continue;
            }

            // 방향 반전
            arr.add(value);
        }

        int N = arr.size();
        long maxHeight = 0;
        for (int i=1; i<N-1; i++) {
            long height = Math.min((arr.get(i) - arr.get(i-1)), (arr.get(i) - arr.get(i+1)));
            maxHeight = Math.max(maxHeight, height);
        }
        System.out.println(maxHeight);

    }

}
