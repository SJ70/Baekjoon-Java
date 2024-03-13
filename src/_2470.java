import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2470 {

    private static int N;
    private static int[] values;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        values = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).sorted().toArray();

        int left = 0;
        int right = N - 1;
        int minAbs = Integer.MAX_VALUE;
        int resultLeft = left;
        int resultRight = right;

        while (left < right) {
//            printStatus(left, right);

            int abs = Math.abs(values[right] + values[left]);
            if (abs < minAbs) {
                minAbs = abs;
                resultLeft = left;
                resultRight = right;
            }

            if (Math.abs(values[right] + values[left + 1]) < Math.abs(values[right - 1] + values[left])) {
                left++;
            }
            else {
                right--;
            }
        }

        System.out.printf("%d %d\n", values[resultLeft], values[resultRight]);
    }

    private static void printStatus(int left, int right) {
        for (int value : values) {
            System.out.printf("%5d", value);
        }
        System.out.println();
        for (int i=0; i<N; i++) {
            System.out.printf("%5c", i==left || i==right ? '^' : ' ');
        }
        System.out.println();
    }

}
