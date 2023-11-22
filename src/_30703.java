import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _30703 {

    private static int N;
    private static List<Integer> temps;
    private static List<Integer> tempTargets;
    private static List<Integer> tempChangeValues;

    private static List<Integer> leastChangeCounts;

    public static void main(String[] args) throws IOException {
        input();
        observeLeastChange();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        temps = inputArr(br.readLine());
        tempTargets = inputArr(br.readLine());
        tempChangeValues = inputArr(br.readLine());
    }

    private static List<Integer> inputArr(String input) {
        return Arrays.stream(input.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void observeLeastChange() {
        leastChangeCounts = IntStream.range(0, N)
                .mapToObj(i -> {
                    int diff = Math.abs(temps.get(i) - tempTargets.get(i));
                    if (diff % tempChangeValues.get(i) == 0) {
                        int leastChangeCount = diff / tempChangeValues.get(i);
                        return leastChangeCount;
                    }
                    return -1;
                })
                .collect(Collectors.toList());
    }

    private static int solve() {
        if (leastChangeCounts.contains(-1)) {
            return -1;
        }
        if (leastChangeCounts.stream()
                .map(value -> value % 2)
                .distinct()
                .count() != 1) {
            return -1;
        }
        return leastChangeCounts.stream()
                .max(Integer::compare)
                .get();
    }
}
