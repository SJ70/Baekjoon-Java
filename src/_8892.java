import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _8892 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        loop: for (int t=0; t<T; t++) {
            int n = Integer.parseInt(br.readLine());
            String[] strings = new String[n];
            for (int i=0; i<n; i++) {
                strings[i] = br.readLine();
            }
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (i==j) {
                        continue;
                    }
                    String mergedString = strings[i] + strings[j];
                    if (isPall(mergedString)) {
                        sb.append(mergedString);
                        sb.append('\n');
                        continue loop;
                    }
                }
            }
            sb.append("0\n");
        }

        System.out.print(sb);
    }

    private static boolean isPall(String string) {
        int length = string.length();
        for (int i=0; i<length/2; i++) {
            if (string.charAt(i) != string.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}
