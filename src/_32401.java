import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _32401 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int result = 0;

        int nCnt = -999;
        int length = -999;

        for (int i=0; i<N; i++) {
            length++;
            if (str.charAt(i) == 'A') {
                if (length >= 3 && nCnt == 1) {
                    result++;
                }
                nCnt = 0;
                length = 1;
            }
            else if (str.charAt(i) == 'N') {
                nCnt++;
            }
//            System.out.print(result);
        }
        System.out.println(result);
    }

}
