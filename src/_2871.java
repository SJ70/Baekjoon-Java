import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;

public class _2871 {

    private static int N;

    private static final PriorityQueue<Alphabet> pq = new PriorityQueue<>((a, b) -> {
        if (a.c == b.c) {
            return b.idx - a.idx;
        }
        else {
            return a.c - b.c;
        }
    });

    private static final Stack<Alphabet> stack = new Stack<>();

    private static class Alphabet {
        char c;
        int idx;
        boolean used;

        public Alphabet(char c, int idx) {
            this.c = c;
            this.idx = idx;
        }

        public void use() {
            this.used = true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        for (int i=0; i<N; i++) {
            char c = str.charAt(i);
            Alphabet a = new Alphabet(c, i);
            pq.add(a);
            stack.push(a);
        }

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i=0; i<N/2; i++) {
            while (stack.peek().used) {
                stack.pop();
            }
            Alphabet a1 = stack.pop();
            a1.use();
            sb1.append(a1.c);

            while (pq.peek().used) {
                pq.poll();
            }
            Alphabet a2 = pq.poll();
            a2.use();
            sb2.append(a2.c);
        }

        String str1 = sb1.toString();
        String str2 = sb2.toString();

        boolean lost = false;
        if (str1.equals(str2)) {
            lost = true;
        }
        else {
            for (int i=0; i<N/2; i++) {
                if (str1.charAt(i) > str2.charAt(i)) {
                    break;
                }
                else if (str1.charAt(i) < str2.charAt(i)) {
                    lost = true;
                    break;
                }
            }
        }
        System.out.println(lost ? "NE" : "DA");
        System.out.println(str2);
    }

}
