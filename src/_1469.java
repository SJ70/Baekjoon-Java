import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class _1469 {

    private static int N;
    private static int[] nums;
    private static boolean[] used;
    private static int usedNumCnt;
    private static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        used = new boolean[N];
        result = new int[2 * N];
        for (int i = 0; i < 2 * N; i++) {
            result[i] = -1;
        }
        dfs(0);

        if (usedNumCnt == N) {
            System.out.println(
                    Arrays.stream(result)
                            .mapToObj(Integer::toString)
                            .collect(Collectors.joining(" "))
            );
        } else {
            System.out.println(-1);
        }

    }

    private static void dfs(int resultIdx) {
//        System.out.println(
//                Arrays.stream(result)
//                        .mapToObj(Integer::toString)
//                        .map(s -> s.equals("-1") ? "." : s)
//                        .collect(Collectors.joining(" "))
//        );
        if (usedNumCnt == N) {
            return;
        }

        if (result[resultIdx] != -1) {
            dfs(resultIdx + 1);
            return;
        }

        for (int i=0; i<N; i++) {
            if (used[i]) {
                continue;
            }
            int num = nums[i];
            int nextIdx = resultIdx + num + 1;
            if (nextIdx >= 2 * N) {
                continue;
            }
            if (result[resultIdx] != -1 || result[nextIdx] != -1) {
                continue;
            }

            used[i] = true;
            usedNumCnt++;
            result[resultIdx] = result[nextIdx] = num;
            if (usedNumCnt == N) {
                return;
            }

            dfs(resultIdx + 1);
            if (usedNumCnt == N) {
                return;
            }

            used[i] = false;
            usedNumCnt--;
            result[resultIdx] = result[nextIdx] = -1;
        }
    }

}
