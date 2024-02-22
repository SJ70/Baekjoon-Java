import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class _1918 {

    public static void main(String[] args) throws IOException {

        Deque<String> deque = new ArrayDeque<>();

        String[] values = input();
        for (String value : values) {
            if (value.equals(")")) {
                deque.addLast(toPostfix(getDequeInsideOfBracket(deque)));
            }
            else {
                deque.addLast(value);
            }
        }
        System.out.println(toPostfix(deque));
    }

    private static String[] input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine().split("");
    }

    private static Deque<String> getDequeInsideOfBracket(Deque<String> deque) {
        Deque<String> newDeque = new ArrayDeque<>();
        while (true) {
            String value = deque.pollLast();
            if (value.equals("(")) {
                break;
            }
            newDeque.addFirst(value);
        }
        return newDeque;
    }

    private static String toPostfix(Deque<String> deque) {

        Deque<String> prevDeque;
        Deque<String> currDeque;

        // 곱셈/나눗셈
        prevDeque = deque;
        currDeque = new ArrayDeque<>();
        while (!prevDeque.isEmpty()) {
            String value = prevDeque.pollFirst();
            if (value.equals("*") || value.equals("/")) {
                String prevValue = currDeque.pollLast();
                String nextValue = prevDeque.pollFirst();
                currDeque.addLast(prevValue + nextValue + value);
            }
            else {
                currDeque.addLast(value);
            }
        }

        // 덧셈/뺄셈
        prevDeque = currDeque;
        currDeque = new ArrayDeque<>();
        while (!prevDeque.isEmpty()) {
            String value = prevDeque.pollFirst();
            if (value.equals("+") || value.equals("-")) {
                String prevValue = currDeque.pollLast();
                String nextValue = prevDeque.pollFirst();
                currDeque.addLast(prevValue + nextValue + value);
            }
            else {
                currDeque.addLast(value);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!currDeque.isEmpty()) {
            sb.append(currDeque.pollFirst());
        }
        return sb.toString();
    }

}
