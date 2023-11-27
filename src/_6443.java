import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _6443 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final int N = 26;
    private static int[] alphabetCounts;
    private static int length;

    private static StringBuilder result = new StringBuilder();
    private static StringBuilder string = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            init();
            dfs();
        }
        System.out.print(result);
    }

    private static void init() throws IOException {
        String str = br.readLine();
        length = str.length();
        alphabetCounts = new int[N];
        char[] chars = str.toCharArray();
        for (char character : chars) {
            alphabetCounts[getIndex(character)]++;
        }
    }

    private static void dfs() {
        if (string.length() == length) {
            result.append(string.toString()).append('\n');
        }
        for (int i = 0; i < N; i++) {
            if (alphabetCounts[i] > 0) {
                alphabetCounts[i]--;
                string.append(getChar(i));
                dfs();
                alphabetCounts[i]++;
                string.deleteCharAt(string.length() - 1);
            }
        }
    }

    private static int getIndex(char character) {
        return character - 'a';
    }

    private static char getChar(int index) {
        return (char) ('a' + index);
    }

}
