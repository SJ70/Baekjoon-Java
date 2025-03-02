import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _31628 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] arr = new String[10][10];
        for (int r=0; r<10; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c=0; c<10; c++) {
                arr[r][c] = st.nextToken();
            }
        }
        loop: for (int r=0; r<10; r++) {
            for (int c=1; c<10; c++) {
                if (!arr[r][c].equals(arr[r][c-1])) {
                    continue loop;
                }
            }
            System.out.println(1);
            return;
        }
        loop: for (int c=0; c<10; c++) {
            for (int r=1; r<10; r++) {
                if (!arr[r][c].equals(arr[r-1][c])) {
                    continue loop;
                }
            }
            System.out.println(1);
            return;
        }
        System.out.println(0);
    }

}
