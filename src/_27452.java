import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _27452 {

    private static List<Long> valueLengths = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        initArr();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            long k = Long.parseLong(st.nextToken());

            // 최대 인덱스보다 클 경우 앞에 부가적인 여는 괄호가 있음
            long diff = n - valueLengths.size();
            if (diff > 0) {
                k -= (diff + 1) / 2;
                if (k <= 0) {
                    sb.append("(\n");
                    continue;
                }
                n = valueLengths.size() - diff % 2;
//                System.out.println(n+","+k);
            }

            if (k > valueLengths.get((int) n - 1)) {
                sb.append("0\n");
                continue;
            }
            sb.append(searchValue((int) n - 1, k));
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private static void initArr() {
        valueLengths.add(2L); // S1
        valueLengths.add(2L); // S2
        for (int i = 2; i < 86; i++) {
            long value = valueLengths.get(i - 2) + valueLengths.get(i - 1) + 2;
            valueLengths.add(value);
        }
//        System.out.println(valueLengths);
//        System.out.println(valueLengths.size());
    }

    private static char searchValue(int valueLengthIndex, long index) {
        long valueLength = valueLengths.get(valueLengthIndex);
        if (index == 1) {
            return '(';
        }
        if (index == valueLength) {
            return ')';
        }

        int leftValueIndex = valueLengthIndex - 2;
        long leftValueLength = valueLengths.get(leftValueIndex);
        if (index <= 1 + leftValueLength) {
            return searchValue(leftValueIndex, index - 1);
        }

        int rightValueIndex = valueLengthIndex - 1;
        long rightValueLength = valueLengths.get(rightValueIndex);
        if (index <= 1 + leftValueLength + rightValueLength) {
            return searchValue(rightValueIndex, index - 1 - leftValueLength);
        }

        throw new RuntimeException("로직 오류");
    }

}
