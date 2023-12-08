import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class _15486 {

    private static class Work {
        public final int days;
        public final long amount;

        public Work(int days, long amount) {
            this.days = days;
            this.amount = amount;
        }
    }

    private static int n;
    private static Work[] works;
    private static long[] maxAmountsPerDays;

    public static void main(String[] args) throws IOException {
        input();
        dp();
        System.out.println(maxAmountsPerDays[n]);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        works = new Work[n];
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int days = Integer.parseInt(st.nextToken());
            long amount = Long.parseLong(st.nextToken());
            works[i] = new Work(days, amount);
        }
    }

    private static void dp() {
        maxAmountsPerDays = new long[n + 1];
        for (int i=1; i<=n; i++) {
            maxAmountsPerDays[i] = Math.max(maxAmountsPerDays[i], maxAmountsPerDays[i - 1]);
            Work todayWork = works[i - 1];
            int todayWorkEndDate = i + todayWork.days - 1;
            if (todayWorkEndDate > n) {
                continue;
            }
            long amountIfDoTodayWork = maxAmountsPerDays[i - 1] + todayWork.amount;
            maxAmountsPerDays[todayWorkEndDate] = Math.max(maxAmountsPerDays[todayWorkEndDate], amountIfDoTodayWork);
//            System.out.println(Arrays.stream(maxAmountsPerDays).mapToObj(Long::valueOf).collect(Collectors.toList()));
        }
    }

}
