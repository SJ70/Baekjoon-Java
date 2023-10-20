import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2118 {

    private static int n;
    private static int[] distances;

    private static int[] prefixDistances;
    private static int entireDistance;

    public static void main(String[] args) throws IOException {
        input();
        prefixSum();
        int minDiff = getMinDiff();
        System.out.println(getLowerValue(entireDistance, minDiff));
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        distances = new int[n];
        for (int i = 0; i < n; i++) {
            distances[i] = Integer.parseInt(br.readLine());
        }
    }

    private static void prefixSum() {
        prefixDistances = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixDistances[i] = distances[i - 1] + prefixDistances[i - 1];
        }
        entireDistance = prefixDistances[n];
    }

    private static int getMinDiff() {
        int minDiff = Integer.MAX_VALUE;

        // sumA의 범위
        int basicLength = 0;

        // sumA 초기 범위 설정
        for (int right = 1; right <= n; right++) {
            int diff = getDiff(1, right);

            if (Math.abs(diff) > Math.abs(minDiff)) {
                break;
            }
            minDiff = diff;
            basicLength = right;
        }
//        System.out.println();

        // 각 left마다 초기 범위 기준으로 right를 측정
        for (int left = 1; left <= n; left++) {
            int right = left + basicLength - 1;

//            System.out.printf("left : %d\n", left);
//            System.out.println("오른쪽");
            // right가 오른쪽으로
            int minDiffRight = Integer.MAX_VALUE;
            for (int nextRight = right; nextRight <= n; nextRight++) {
                int diff = getDiff(left, nextRight);

                if (diff > minDiffRight) {
                    break;
                }
                minDiffRight = diff;
            }

//            System.out.println("왼쪽");
            // right가 왼쪽으로
            int minDiffLeft = Integer.MAX_VALUE;
            for (int nextRight = right; nextRight >= left && nextRight <= n; nextRight--) {
                int diff = getDiff(left, nextRight);

                if (diff > minDiffLeft) {
                    break;
                }
                minDiffLeft = diff;
                right++;
            }

            minDiff = Math.min(Math.min(minDiffRight, minDiffLeft), minDiff);

        }

        return minDiff;
    }

    private static int getDiff(int left, int right) {
        int sumA = prefixDistances[right] - prefixDistances[left - 1];
        int sumB = entireDistance - sumA;
//        System.out.printf("sumA: %d, sumB: %d\n", sumA, sumB);
        return Math.abs(sumA - sumB);
    }

    private static int getLowerValue(int sum, int diff) {
        return (sum - diff) / 2;
    }
}
