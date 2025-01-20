import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _8394 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(1);
            return;
        }
        int no = 1;
        int left = 1;
        for (int i=2; i<N; i++) {
            int nextNo = (no + left) % 10;
            int nextLeft = no;
            no = nextNo;
            left = nextLeft;
        }
        System.out.println((no + left) % 10);
    }

}
