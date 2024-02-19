import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class _1662 {

    // 변경하는 이유 : 문자열의 길이가 괄호의 아스키코드와 같아질 수 있기 때문
    private static final int OPENER = -1;
    private static final int CLOSER = -2;

    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {

        int[] values = inputValues();
//        System.out.println("가공 전 : \n"+Arrays.stream(values).mapToObj(_1662::getStringValue).toList() + '\n');

        replaceStringToLength(values);
//        System.out.println("가공 후 : \n"+Arrays.stream(values).mapToObj(_1662::getStringValue).toList() + '\n');

        for (int value : values) {
//            System.out.println(stack.stream().map(_1662::getStringValue).toList() + "  <-  " + getStringValue(value));
            if (value == CLOSER) {
                compress();
            }
            else {
                stack.push(value);
            }
        }

        System.out.println(stack.stream().mapToInt(Integer::valueOf).sum());

    }

    private static int[] inputValues() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        return Arrays.stream(str.split("")).mapToInt(value -> {
            if (value.equals("(")) {
                return OPENER;
            }
            if (value.equals(")")) {
                return CLOSER;
            }
            return Integer.parseInt(value);
        }).toArray();
    }

    // K와 괄호를 제외한 숫자를 모두 1(문자열의 길이)로 변경
    private static void replaceStringToLength(int[] values) {
        for (int i = 0; i < values.length; i++) {
            // 괄호
            if (values[i] == OPENER || values[i] == CLOSER) {
                continue;
            }
            // K
            if (i + 1 < values.length && values[i + 1] == OPENER) {
                continue;
            }
            values[i] = 1;
        }
    }

    private static void compress() {

        int Q = 0;

        for (int value = stack.pop(); value != OPENER; value = stack.pop()) {
            Q += value;
        }

        int K = stack.pop();

        stack.push(K * Q);
    }

    // log
    private static String getStringValue(int value) {
        return value == OPENER ? "(" : value == CLOSER ? ")" : String.valueOf(value);
    }

}
