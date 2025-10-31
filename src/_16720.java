import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _16720 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] cnt = new int[4];
        for (int i=0; i<N-2; i++) {
            String input = br.readLine();
            for (int j=0; j<input.length(); j++) {
                if (input.charAt(j) == '0') {
                    cnt[j]++;
                    break;
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i=0; i<4; i++) {
            int resultTmp = N + 2;
            for (int j=0; j<4; j++) {
                if (i == j) {
                    continue;
                }
                if (i == 0 && j == 3 || i == 3 && j == 0) {
                    resultTmp += cnt[j];
                }
                else {
                    resultTmp += Math.abs(i - j) * cnt[j];
                }
            }
            result = Math.min(resultTmp, result);
        }

        System.out.println(result);
    }

}
