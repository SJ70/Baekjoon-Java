import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class _4891 {

    private static List<Integer> decimals = new ArrayList<>();
    private static Boolean[] isDecimal = new Boolean[1000001];

    private static class Spot {

        Map<Integer, Integer> usedDecimals = new HashMap<>();

        public Spot (int value) {
            for (int decimal : decimals) {
                while (value > 0 && value % decimal == 0) {
                    usedDecimals.put(decimal, usedDecimals.getOrDefault(decimal, 0) + 1);
                    value /= decimal;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {

        isDecimal[0] = isDecimal[1] = false;
        for (int i=2; i<=1000000; i++) {
            if (isDecimal[i] == null) {
                isDecimal[i] = true;
                decimals.add(i);
            }
            if (isDecimal[i]) {
                for (int j=i+i; j<=1000000; j+=i) {
                    isDecimal[j] = false;
                }
            }
        }
//        System.out.println(decimals);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int i=1; true; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0) {
                break;
            }

            Spot spot1 = new Spot(a);
            Spot spot2 = new Spot(b);

            Set<Integer> usedDecimalsSet = new HashSet<>();
            usedDecimalsSet.addAll(spot1.usedDecimals.keySet());
            usedDecimalsSet.addAll(spot2.usedDecimals.keySet());

            int diff = 0;
            for (int decimal : usedDecimalsSet) {
                int tmp1 = spot1.usedDecimals.getOrDefault(decimal, 0);
                int tmp2 = spot2.usedDecimals.getOrDefault(decimal, 0);
                diff += Math.abs(tmp1 - tmp2);
            }

            sb.append(String.format("%d. %d:%d\n", i, usedDecimalsSet.size(), diff));
        }
        System.out.print(sb);

    }

}
