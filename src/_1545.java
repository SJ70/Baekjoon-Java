import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1545 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int[] alphabets = new int[26];
        for (char c : input.toCharArray()) {
            alphabets[c - 'a']++;
        }

        int N = input.length();
        int[] answer = new int[N];
        for (int i=0; i<N; i++) {
            answer[i] = -1;
        }
        loop: for (int i=0; i<N; i++) {
            for (int j=0; j<26; j++) {
                if (alphabets[j] > 0 && answer[N - 1 - i] != j) {
                    answer[i] = j;
                    alphabets[j]--;
                    continue loop;
                }
            }
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : answer) {
            sb.append((char)(i + 'a'));
        }
        System.out.println(sb);
    }

}
