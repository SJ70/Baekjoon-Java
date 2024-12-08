import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _4493 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            int N = Integer.parseInt(br.readLine());
            int value = 0;
            for (int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char a = st.nextToken().charAt(0);
                char b = st.nextToken().charAt(0);
                value += rsp(a, b);
            }
            String result = "";
            if (value < 0) {
                result = "Player 2\n";
            }
            else if (value > 0) {
                result = "Player 1\n";
            }
            else {
                result = "TIE\n";
            }
            sb.append(result);
        }
        System.out.print(sb);
    }

    private static int rsp(char a, char b) {
        if (a == b) {
            return 0;
        }
        switch (a) {
            case 'R' : return b == 'S' ? 1 : -1;
            case 'S' : return b == 'P' ? 1 : -1;
            case 'P' : return b == 'R' ? 1 : -1;
        }
        throw new RuntimeException();
    }

}
