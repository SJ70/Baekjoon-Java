import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class _28279 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int value = Integer.parseInt(st.nextToken());
            switch (value) {
                case 1 :
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case 2 :
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case 3 :
                    sb.append(deque.isEmpty() ? -1 : deque.pollFirst());
                    sb.append('\n');
                    break;
                case 4 :
                    sb.append(deque.isEmpty() ? -1 : deque.pollLast());
                    sb.append('\n');
                    break;
                case 5 :
                    sb.append(deque.size());
                    sb.append('\n');
                    break;
                case 6 :
                    sb.append(deque.isEmpty() ? 1 : 0);
                    sb.append('\n');
                    break;
                case 7 :
                    sb.append(deque.isEmpty() ? -1 : deque.peekFirst());
                    sb.append('\n');
                    break;
                case 8 :
                    sb.append(deque.isEmpty() ? -1 : deque.peekLast());
                    sb.append('\n');
                    break;
                default:
                    break;
            }
        }
        System.out.print(sb);
    }

}
