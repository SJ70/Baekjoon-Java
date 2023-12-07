import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class _1477 {

    private static int maxLength;
    private static List<Integer> lengths = new ArrayList<>();
    private static int buildCountTarget;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(getResult());
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        buildCountTarget = Integer.parseInt(st.nextToken());
        maxLength = Integer.parseInt(st.nextToken());

        if (n != 0) {
            lengths = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .sorted()
                    .collect(Collectors.toList());
        }
        lengths.add(maxLength);

        for (int i=n; i>=1; i--) {
            lengths.set(i, lengths.get(i) - lengths.get(i-1));
        }

//        System.out.println(lengths);
    }

    private static int getResult() {
        for (int result = 1; result < maxLength; result++) {
            int buildCount = 0;
            for (int length : lengths) {
                int divider = length / result;
                int remainder = length % result;
                if (remainder == 0) {
                    buildCount += divider - 1;
                }
                else {
                    buildCount += divider;
                }
            }
            if (buildCount <= buildCountTarget) {
                return result;
            }
        }
        return -1;
    }

}
