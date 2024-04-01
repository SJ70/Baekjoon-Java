import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class _1252 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();

        int[] result = new int[81];

        int aIdx = a.length() - 1;
        int bIdx = b.length() - 1;
        int resultIdx = 80;

        for (; resultIdx > 0; aIdx--, bIdx--, resultIdx--) {
            int aValue = aIdx >= 0 ? a.charAt(aIdx) - '0' : 0;
            int bValue = bIdx >= 0 ? b.charAt(bIdx) - '0' : 0;

            result[resultIdx] += (aValue + bValue) % 2;
            result[resultIdx - 1] += (aValue + bValue) / 2;

            result[resultIdx - 1] += result[resultIdx] / 2;
            result[resultIdx] = result[resultIdx] % 2;
        }

        StringBuilder sb = new StringBuilder();
        boolean numberStarted = false;
        for (int value : result) {
            if (!numberStarted && value == 1) {
                numberStarted = true;
            }
            if (numberStarted) {
                sb.append(value);
            }
        }
        System.out.println(sb.length() == 0 ? 0 : sb);

    }

}
