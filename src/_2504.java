import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class _2504 {

    private static Stack<Object> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        String[] values = new BufferedReader(new InputStreamReader(System.in)).readLine().split("");

        try {
            System.out.println(getResult(values));
        } catch (Exception e) {
            System.out.println(0);
        }
    }

    private static int getResult(String[] values) {
        Arrays.stream(values)
                .forEach(value -> {
                    switch (value) {
                        case "(":
                        case "[":
                            stack.push(value);
                            break;
                        case ")":
                        case "]":
                            close(value);
                            break;
                        default:
                            throw new IllegalArgumentException();
                    }
//                    System.out.println(stack);
                });

        if (stack.stream().anyMatch(value -> value.getClass() == String.class)) {
            throw new IllegalArgumentException();
        }

        return stack.stream()
                .mapToInt(value -> (Integer) value)
                .sum();
    }

    private static void close(String closeValue) {
        String openValue = getOpenValue(closeValue);
        int multiplyValue = getMultiplyValue(closeValue);

        int tmp = 0;
        if (stack.peek().equals(openValue)) {
            tmp = 1;
        }
        while (true) {
            Object pop = stack.pop();
            if (pop.equals(openValue)) {
                stack.push(tmp * multiplyValue);
                break;
            }
            tmp += (int) pop;
        }
    }

    private static String getOpenValue(String closeValue) {
        return closeValue.equals(")") ? "(" : "[";
    }

    private static int getMultiplyValue(String closeValue) {
        return closeValue.equals(")") ? 2 : 3;
    }

}
