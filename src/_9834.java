import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class _9834 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Deque<Integer> d = new ArrayDeque<>();
        for (int i=0; i<M; i++) {
            d.add(i);
        }
        String input = st.nextToken();
        for (char c : input.toCharArray()) {
            switch (c) {
                case 'A' :
                    d.addLast(d.pollFirst());
                    break;
                case 'B' :
                    int tmp = d.pollFirst();
                    d.addLast(d.pollFirst());
                    d.addFirst(tmp);
                    break;
            }
        }
        for (int i=0; i<K-1; i++) {
            d.pollFirst();
        }
        System.out.print(d.pollFirst());
        System.out.print(' ');
        System.out.print(d.pollFirst());
        System.out.print(' ');
        System.out.print(d.pollFirst());

    }

}
