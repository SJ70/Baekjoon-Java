import java.io.*;

public class _1342 {

    private static int[] alphabetCounts = new int[26];
    private static int length;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
        length = str.length();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            alphabetCounts[c - 'a']++;
        }
        dfs(-1, 0);
        System.out.println(result);
    }

    private static void dfs(int lastCharValue, int currentLength) {
        if (currentLength == length) {
            result++;
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (alphabetCounts[i] > 0 && i != lastCharValue) {
                alphabetCounts[i]--;
                dfs(i, currentLength + 1);
                alphabetCounts[i]++;
            }
        }
    }

}
