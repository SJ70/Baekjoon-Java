import java.util.Stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _12789 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int requiredValue = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<n; i++) {
            int value = Integer.parseInt(st.nextToken());

            if (value == requiredValue) {
                requiredValue++;
            }
            else {
                stack.push(value);
            }

            while (!stack.isEmpty() && stack.peek()==requiredValue) {
                requiredValue++;
                stack.pop();
            }
        }

        System.out.println(stack.isEmpty() ? "Nice" : "Sad");
    }

}
