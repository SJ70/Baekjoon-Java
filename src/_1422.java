import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1422 {

    private static int N;
    private static int K;
    private static String[] numberStrings;

    public static void main(String[] args) throws IOException {

        input();
        sort();
        String largestNumberString = getLargestNumberString();

        // 모든 숫자를 한 번씩 사용
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            sb.append(numberStrings[i]);

            // 가장 큰 수라면 더 집어넣는다.
            if (numberStrings[i] == largestNumberString) {
                sb.append(numberStrings[i].repeat(K - N));
            }
        }

        System.out.println(sb);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        numberStrings = new String[N];
        for (int i=0; i<N; i++) {
            numberStrings[i] = br.readLine();
        }
    }

    private static void sort() {
        Arrays.sort(numberStrings, (String o1, String o2) -> {
            int o1Length = o1.length();
            int o2Length = o2.length();
            int length = o1Length + o2Length;
            for (int i=0; i<length; i++) {
                char o1Value = (i < o1Length) ? o1.charAt(i) : o2.charAt(i - o1Length);
                char o2Value = (i < o2Length) ? o2.charAt(i) : o1.charAt(i - o2Length);
                if (o1Value != o2Value) {
                    // 큰 순서
                    return o2Value - o1Value;
                }
            }
            return 0;
        });
    }

    private static String getLargestNumberString() {
        int maxValue = Integer.MIN_VALUE;
        String result = "";

        for (String numberString : numberStrings) {
            if (result.length() > numberString.length()) {
                continue;
            }
            if (result.length() < numberString.length()) {
                result = numberString;
                maxValue = Integer.parseInt(numberString);
                continue;
            }
            // result.length() == numberString.length()
            int numberStringIntValue = Integer.parseInt(numberString);
            if (maxValue < numberStringIntValue) {
                result = numberString;
                maxValue = numberStringIntValue;
            }
        }
        return result;
    }

}
