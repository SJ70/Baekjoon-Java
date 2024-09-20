import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _12347 {

    private static final int[][] possibleDiffs = {
            {0, 0},
            {0, 0}, {-9, 8}, {-4, 4}, {-3, 2}, {-2, 2},
            {-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}, {-1, 0},
            {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0},
            {0, 0}, {0, 0}, {0, 0}
    };

    public static void main(String[] args) throws IOException {

        List<Long> hansoos = new ArrayList<>();
        for (int length = 1; length <= 18; length++) {
            int minDiff = possibleDiffs[length][0];
            int maxDiff = possibleDiffs[length][1];
            for (int diff = minDiff; diff <= maxDiff; diff++) {

                for (int firstValue=1; firstValue<=9; firstValue++) {
                    // 1의 자리 값이 범위 외라면 continue
                    int lastValue = firstValue+(length-1)*diff;
                    if (lastValue > 9 || lastValue < 0) {
                        continue;
                    }

                    long resultValue = 0;
                    for (int i = 0; i < length; i++) {
                        resultValue *= 10;
                        resultValue += firstValue + ((long)diff * i);
                    }
                    hansoos.add(resultValue);
                }
            }
        }
//        System.out.println(hansoos);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long result = hansoos.stream().filter(value -> value <= N).count();
        System.out.println(result);

    }

}
