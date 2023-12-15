import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _20164 {

    private static int minResult = Integer.MAX_VALUE;
    private static int maxResult = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        cutNumber(N, 0);
        System.out.printf("%d %d\n", minResult, maxResult);
    }

    private static void cutNumber(int num, int oddCount) {
        oddCount += countOdd(num);
//        System.out.printf("num: %d, oddCount: %d\n", num, oddCount);

        int length = getLength(num);
//        System.out.println(length);

        if (length == 1) {
            minResult = Math.min(minResult, oddCount);
            maxResult = Math.max(maxResult, oddCount);
//            System.out.println();
            return;
        }

        if (length == 2) {
            int nextNum = num / 10 + num % 10;
            cutNumber(nextNum, oddCount);
        }

        // length >= 3
        for (int i = 10; i <= num; i *= 10) {
            for (int j = i * 10; j <= num; j *= 10) {
                int nextNum = cutNumAndGetSum(num, i, j);
                cutNumber(nextNum, oddCount);
            }
        }
    }

    private static int getLength(int num) {
        if (num == 0) {
            return 1;
        }
        return (int) Math.log10(num) + 1;
    }

    private static int countOdd(int num) {
        int count = 0;
        while (num > 0) {
            count += num % 2;
            num /= 10;
        }
        return count;
    }

    private static int cutNumAndGetSum(int num, int i, int j) {
        int leftNum = num / j;
        int middleNum = num % j / i;
        int rightNum = num % i;
//        System.out.printf("i:%d, j:%d : %d %d %d\n",i, j, leftNum, middleNum, rightNum);
        return leftNum + middleNum + rightNum;
    }

}
