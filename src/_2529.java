import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class _2529 {

    private static int n;
    private static char[] signs;

    private static String largestNumber;
    private static String smallestNumber;

    private static int[] nums;
    private static boolean[] usedNums;

    public static void main(String[] args) throws IOException {
        input();

        nums = new int[n + 1];
        usedNums = new boolean[10];
        fillLargestNumber(0);

        nums = new int[n + 1];
        usedNums = new boolean[10];
        fillSmallestNumber(0);

        System.out.printf("%s\n%s\n", largestNumber, smallestNumber);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        signs = Arrays.stream(br.readLine().split(" ")).collect(Collectors.joining()).toCharArray();
    }

    private static void fillLargestNumber(int i) {

        if (largestNumber != null) {
            return;
        }

        for (int num = 9; num >= 0; num--) {
            if (usedNums[num]) {
                continue;
            }
            usedNums[num] = true;
            nums[i] = num;

            if ((i == 0) || (signs[i - 1] == '>' && nums[i - 1] > nums[i]) || (signs[i - 1] == '<' && nums[i - 1] < nums[i])) {
                if (i == n) {
                    largestNumber = Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining());
                    return;
                }
                fillLargestNumber(i + 1);
            }

            usedNums[num] = false;
        }
    }

    private static void fillSmallestNumber(int i) {

        if (smallestNumber != null) {
            return;
        }

        for (int num = 0; num <= 9; num++) {
            if (usedNums[num]) {
                continue;
            }
            usedNums[num] = true;
            nums[i] = num;

            if ((i == 0) || (signs[i - 1] == '>' && nums[i - 1] > nums[i]) || (signs[i - 1] == '<' && nums[i - 1] < nums[i])) {
                if (i == n) {
                    smallestNumber = Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining());
                    return;
                }
                fillSmallestNumber(i + 1);
            }

            usedNums[num] = false;
        }
    }

}
