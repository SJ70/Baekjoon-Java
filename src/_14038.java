import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _14038 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int winCnt = 0;
        for (int i=0; i<6; i++) {
            if (br.readLine().equals("W")) {
                winCnt++;
            }
        }

        if (winCnt >= 5) {
            System.out.println(1);
        }
        else if (winCnt >= 3) {
            System.out.println(2);
        }
        else if (winCnt >= 1) {
            System.out.println(3);
        }
        else {
            System.out.println(-1);
        }

    }

}
