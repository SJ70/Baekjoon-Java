import java.io.*;
import java.util.*;

public class _3518 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<List<String>> inputs = new ArrayList<>();

        String input = "";
        while ((input = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            List<String> strings = new ArrayList<>();
            while (st.hasMoreTokens()) {
                strings.add(st.nextToken());
            }
            inputs.add(strings);
        }

        int[] maxLengths = new int[180];

        for (List<String> strings : inputs) {
            int stringCnt = strings.size();
            for (int i=0; i<stringCnt; i++) {
                String string = strings.get(i);
                int length = string.length();
                maxLengths[i] = Math.max(length, maxLengths[i]);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (List<String> strings : inputs) {
            int stringCnt = strings.size();
            for (int i=0; i<stringCnt; i++) {
                String string = strings.get(i);
                int maxLength = maxLengths[i];
                int stringLength = string.length();
                int blankCount = maxLength - stringLength;
                sb.append(string);
                if (i == stringCnt - 1) {
                    sb.append('\n');
                }
                else {
                    String blanks = " ".repeat(blankCount + 1);
                    sb.append(blanks);
                }
            }
        }

        System.out.print(sb);
    }
}
