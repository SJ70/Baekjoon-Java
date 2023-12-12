import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _3151 {

    private static int n;
    private static List<Integer> nums;
    private static long result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
//        System.out.println(nums);

        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                int num1 = nums.get(i);
                int num2 = nums.get(j);
                int target = - (num1 + num2);
                result += findCountOfNumber(target, j + 1, n - 1);
            }
        }

        System.out.println(result);
    }

    private static int findCountOfNumber(int target, int left, int right) {
        int leftIndex = findLeftIndexOfNumber(target, left, right);
        if (leftIndex == -1) {
            return 0;
        }
        int rightIndex = findRightIndexOfNumber(target, left, right);
//        System.out.printf("------------- found %d : %d개\n",target, rightIndex - leftIndex + 1);
        return rightIndex - leftIndex + 1;
    }

    private static int findLeftIndexOfNumber(int target, int left, int right) {
//        System.out.printf("%3d ? %d ~ %d\n",target, left, right);
        if (left > right) {
            return -1;
        }
        if (nums.get(left) == target) {
            return left;
        }
        if (nums.get(left) > target) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midValue = nums.get(mid);
        if (midValue == target && nums.get(mid - 1) < target) {
            return mid;
        }
        if (midValue == target) {
            return findLeftIndexOfNumber(target, left, mid);
        }
        if (midValue > target) {
        return findLeftIndexOfNumber(target, left, mid - 1);
        }
//        if (midValue < target) {
            return findLeftIndexOfNumber(target, mid + 1, right);
//        }
    }

    private static int findRightIndexOfNumber(int target, int left, int right) {
//        System.out.printf("%3d ? %d ~ %d\n",target, left, right);
        if (left > right) {
            return -1;
        }
        if (nums.get(right) == target) {
            return right;
        }
        if (nums.get(right) < target) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midValue = nums.get(mid);
        if (midValue == target && nums.get(mid + 1) > target) {
            return mid;
        }
        if (midValue == target) {
            return findRightIndexOfNumber(target, mid, right);
        }
        if (midValue < target) {
            return findRightIndexOfNumber(target, mid + 1, right);
        }
//        if (midValue > target) {
        return findRightIndexOfNumber(target, left, mid - 1);
//        }
    }

}