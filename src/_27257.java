import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class _27257 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : str.toCharArray()) {
            deque.addLast(c);
        }
        while (!deque.isEmpty() && deque.peekLast() == '0') {
            deque.pollLast();
        }
        while (!deque.isEmpty() && deque.peekFirst() == '0') {
            deque.pollFirst();
        }
        int result = 0;
        while (!deque.isEmpty()) {
            char value = deque.pollFirst();
            if (value == '0') {
                result++;
            }
        }
        System.out.println(result);
    }

}
