import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _28238 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static List<Integer> values;
    private static List<String> cases;

    public static void main(String[] args) throws IOException {
        init();

        String result = cases.stream()
                .max(Comparator.comparingInt(_28238::getValidCount))
                .get();

        System.out.println(getValidCount(result));
        System.out.println(Arrays.stream(result.split("")).collect(Collectors.joining(" ")));
    }

    private static void init() throws IOException {
        int n = Integer.parseInt(br.readLine());

        values = Stream.generate(() -> inputNumber())
                .limit(n)
                .collect(Collectors.toList());

        cases = List.of("11000", "10100", "10010", "10001", "01100", "01010", "01001", "00110", "00101", "00011");
    }

    private static Integer inputNumber() {
        String binaryString = String.join("", input().split(" "));
        return Integer.parseInt(binaryString, 2);
    }

    private static String input() {
        try {
            return br.readLine();
        } catch (Exception e) {
            return "";
        }
    }

    private static int getValidCount(String caseStringValue) {
        int caseValue = Integer.valueOf(caseStringValue, 2);
        return (int) values.stream()
                .filter(value -> (value & caseValue) == caseValue)
                .count();
    }

}
