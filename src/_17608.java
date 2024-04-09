import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _17608 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<n; i++) {
            s.push(Integer.parseInt(br.readLine()));
        }

        int maxValue = s.pop();
        int result = 1;

        while(!s.isEmpty()) {
            int value = s.pop();
            if (maxValue < value) {
                maxValue = value;
                result++;
            }
        }

        System.out.println(result);
    }

}
