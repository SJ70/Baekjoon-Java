import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _6198 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long result = 0;
        Stack<Integer> heights = new Stack<>();
        for (int i=0; i<N; i++) {
            int height = Integer.parseInt(br.readLine());
            while (!heights.isEmpty() && heights.peek() <= height) {
                heights.pop();
            }
            result += heights.size();
            heights.push(height);
        }
        System.out.println(result);
    }

}
