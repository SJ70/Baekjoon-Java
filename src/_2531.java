import java.io.*;
import java.util.*;

public class _2531 {

    private static int plateCount;
    private static int sushiKindCount;
    private static int eatingCount;
    private static int bonusSushiNumber;

    private static int[] sushiNumbers;

    private static final Map<Integer, Integer> eatenSushiCounts = new HashMap<>();

    public static void main(String[] args) throws IOException {
        input();
        int result = getMaxEatableSushiCount();
        System.out.println(result);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        plateCount = Integer.parseInt(st.nextToken());
        sushiKindCount = Integer.parseInt(st.nextToken());
        eatingCount = Integer.parseInt(st.nextToken());
        bonusSushiNumber = Integer.parseInt(st.nextToken());

        sushiNumbers = new int[plateCount];
        for (int i = 0; i < plateCount; i++) {
            sushiNumbers[i] = Integer.parseInt(br.readLine());
        }

        eatSushi(bonusSushiNumber);
    }

    private static int getMaxEatableSushiCount() {

        for (int i = 0; i < eatingCount; i++) {
            int sushiNumber = sushiNumbers[i];
            eatSushi(sushiNumber);
        }
        int maxEatableSushiCount = eatenSushiCounts.size();

        for (int i = 0; i < plateCount; i++) {

            int eatIndex = (i + eatingCount) % plateCount;
            eatSushi(sushiNumbers[eatIndex]);

            int vomitIndex = i;
            vomitSushi(sushiNumbers[vomitIndex]);

            maxEatableSushiCount = Math.max(maxEatableSushiCount, eatenSushiCounts.size());
        }

        return maxEatableSushiCount;
    }

    private static void eatSushi(int sushiNumber) {
        int eatenSushiCount = eatenSushiCounts.getOrDefault(sushiNumber, 0);
        eatenSushiCounts.put(sushiNumber, eatenSushiCount + 1);
    }

    private static void vomitSushi(int sushiNumber) {
        int eatenSushiCount = eatenSushiCounts.get(sushiNumber);
        if (eatenSushiCount == 1) {
            eatenSushiCounts.remove(sushiNumber);
        } else {
            eatenSushiCounts.put(sushiNumber, eatenSushiCount - 1);
        }
    }
}
