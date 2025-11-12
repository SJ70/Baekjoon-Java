import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class _2374 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<N; i++) {
            int value = Integer.parseInt(br.readLine());
            int last = stack.isEmpty()
                    ? -1
                    : stack.peek();
            if (value != last) {
                stack.push(value);
            }

            // 중간 값 승격
            while (stack.size() >= 3) {
                int v3 = stack.pop();
                int v2 = stack.pop();
                int v1 = stack.pop();
                if (v1 > v2 && v2 < v3) {
                    int target = Math.min(v1, v3);
                    result += (long) target - v2;
                    if (v1 == v3) {
                        stack.push(v1);
                    } else {
                        stack.push(v1);
                        stack.push(v3);
                    }
                } else {
                    stack.push(v1);
                    stack.push(v2);
                    stack.push(v3);
                    break;
                }

            }

            // 첫 값 승격
            if (stack.size() == 2) {
                int v2 = stack.pop();
                int v1 = stack.pop();
                if (v1 < v2) {
                    result += (long) v2 - v1;
                    stack.push(v2);
                } else {
                    stack.push(v1);
                    stack.push(v2);
                }
            }

        }

        // 마지막 값 승격
        while (stack.size() > 1) {
            int v2 = stack.pop();
            int v1 = stack.peek();
            result += (long) v1 - v2;
        }

        System.out.println(result);

    }

}
