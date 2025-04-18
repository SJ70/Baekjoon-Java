import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _32905 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            boolean foundA = false;
            for (int j=0; j<M; j++) {
                char c = st.nextToken().charAt(0);
                if (c == 'A') {
                    if (foundA) {
                        System.out.println("No");
                        return;
                    }
                    else {
                        foundA = true;
                    }
                }
            }
            if (!foundA) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }

}
