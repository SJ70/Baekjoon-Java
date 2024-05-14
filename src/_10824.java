import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10824 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = new String[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<4; i++) {
            arr[i] = st.nextToken();
        }
        System.out.printf("%d", Long.parseLong(arr[0]+arr[1]) + Long.parseLong(arr[2]+arr[3]));
    }

}
