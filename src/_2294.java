import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _2294 {

    private static int amountTarget;

    private static int coinValueCnt;
    private static List<Integer> coinValues = new ArrayList<>();

    private static Coins[] dpArr;
    private static Queue<Integer> dpIndexQueue = new ArrayDeque<>();

    private static class Coins {
        List<Integer> coinCnts;

        public Coins () {
            coinCnts = IntStream.generate(() -> 0).limit(coinValueCnt).boxed().collect(Collectors.toList());
        }

        public Coins (Coins prevCoinCnts, int index) {
            coinCnts = new ArrayList<>(prevCoinCnts.coinCnts);
            coinCnts.set(index, coinCnts.get(index) + 1);
        }

        public int getEntireAmount() {
            int entireAmount = 0;
            for (int i=0; i<coinValueCnt; i++) {
                entireAmount += coinValues.get(i) * coinCnts.get(i);
            }
            return entireAmount;
        }

        public int getEntireCoinCnts() {
            return coinCnts.stream().mapToInt(Integer::valueOf).sum();
        }

        public String toString() {
            return coinCnts.stream().map(String::valueOf).collect(Collectors.joining(",")) + " -> " + this.getEntireAmount();
        }

    }

    public static void main(String[] args) throws IOException {
        input();
        dp();

        if (dpArr[amountTarget] == null) {
            System.out.println(-1);
        }
        else {
            System.out.println(dpArr[amountTarget].getEntireCoinCnts());
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        coinValueCnt = Integer.parseInt(st.nextToken());
        amountTarget = Integer.parseInt(st.nextToken());

        for (int i=0; i<coinValueCnt; i++) {
            coinValues.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(coinValues, Collections.reverseOrder());
    }

    private static void dp() {
        dpArr = new Coins[amountTarget + 1];
        dpArr[0] = new Coins();
        dpIndexQueue.add(0);

        while(!dpIndexQueue.isEmpty()) {
            int i = dpIndexQueue.poll();

            if (dpArr[i] == null) {
                continue;
            }
            for (int j=0; j<coinValueCnt; j++) {
                int entireAmount = dpArr[i].getEntireAmount() + coinValues.get(j);
                if (entireAmount > amountTarget || dpArr[entireAmount] != null) {
                    continue;
                }
                dpArr[entireAmount] = new Coins(dpArr[i], j);
                dpIndexQueue.add(entireAmount);
                if (entireAmount == amountTarget) {
                    return;
                }
            }
//            System.out.println(Arrays.asList(dpArr));
        }
    }

}
