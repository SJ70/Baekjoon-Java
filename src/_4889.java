import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class _4889 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int t=1; true; t++) {
            String input = br.readLine();
            if (input.startsWith("-")) {
                break;
            }

            Deque<Character> shorterString = new ArrayDeque<>();
            for (char value : input.toCharArray()) {
                switch (value) {
                    case '{' :
                        shorterString.addLast('{');
                        break;
                    case '}' :
                        if (!shorterString.isEmpty() && shorterString.peekLast() == '{') {
                            shorterString.pollLast();
                        }
                        else {
                            shorterString.addLast('}');
                        }
                        break;
                }
            }

            int changeCnt = 0;
            while (!shorterString.isEmpty()) {
                char a = shorterString.pollFirst();
                char b = shorterString.pollFirst();
                if (a == b) {
                    changeCnt++;
                }
                else {
                    changeCnt += 2;
                }
            }

            sb.append(String.format("%d. %d\n", t, changeCnt));
        }
        System.out.print(sb);

    }

}
