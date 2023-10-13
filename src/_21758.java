import java.io.*;
import java.util.*;

public class _21758 {

    private static int n;
    private static int[] values;
    private static int[] prefix_sum;

    public static void main(String[] args) throws IOException {
        init();
        int result1 = getResult_Bee_Hive_Bee();
        int result2 = getResult_Hive_Bee_Bee();
        int result3 = getResult_Bee_Bee_Hive();
        int minResult = getMaxValue(result1, result2, result3);
        System.out.println(minResult);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        values = new int[n];
        prefix_sum = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=1; i<=n; i++) {
            prefix_sum[i] = prefix_sum[i-1] + values[i-1];
        }
    }

    private static int getPrefixSum(int fromIndex, int untilIndex) {
        return prefix_sum[untilIndex + 1] - prefix_sum[fromIndex];
    }

    private static int getResult_Bee_Hive_Bee() {
        int entireHoney = getPrefixSum(1,n - 2);

        int hiveValue = -1;
        for (int i = 1; i < n - 1; i++) {
            hiveValue = Math.max(hiveValue, values[i]);
        }

        return entireHoney + hiveValue;
    }

    private static int getResult_Hive_Bee_Bee(){
        int secondBeeIndex = n - 1;
        int secondBeeValue = getPrefixSum(0, secondBeeIndex - 1);

        int maxResultValue = -1;

        for (int firstBeeIndex = 1; firstBeeIndex < secondBeeIndex; firstBeeIndex++) {
            int firstBeeValue = getPrefixSum(0, firstBeeIndex - 1);
            int resultValue = secondBeeValue + firstBeeValue - values[firstBeeIndex];
            maxResultValue = Math.max(maxResultValue, resultValue);
        }

        return maxResultValue;
    }

    private static int getResult_Bee_Bee_Hive(){
        int firstBeeIndex = 0;
        int firstBeeValue = getPrefixSum(firstBeeIndex + 1, n - 1);

        int maxResultValue = -1;

        for (int secondBeeIndex = 1; secondBeeIndex < n; secondBeeIndex++) {
            int secondBeeValue = getPrefixSum(secondBeeIndex + 1, n - 1);
            int resultValue = firstBeeValue + secondBeeValue - values[secondBeeIndex];
            maxResultValue = Math.max(maxResultValue, resultValue);
        }

        return maxResultValue;
    }

    private static int getMaxValue(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }
}
