import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11531 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[26];
        int rightCnt = 0;
        int score = 0;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            if (time == -1) {
                break;
            }
            int prob = st.nextToken().charAt(0) - 'A';
            boolean right = st.nextToken().charAt(0) == 'r';

            if (right) {
                rightCnt++;
                score += time + arr[prob] * 20;
            }
            else {
                arr[prob]++;
            }
        }
        System.out.printf("%d %d\n", rightCnt, score);
    }

}
