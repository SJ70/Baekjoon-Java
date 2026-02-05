import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10205 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t=1; t<=T; t++) {
            int cnt = Integer.parseInt(br.readLine());
            String str = br.readLine();
            for (char c : str.toCharArray()) {
                if (cnt == 0) {
                    break;
                }
                if (c == 'c') {
                    cnt++;
                }
                else {
                    cnt--;
                }
            }
            sb.append(String.format("Data Set %d:\n%d\n", t, cnt));
            if (t < T) {
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }

}
