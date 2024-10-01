import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15719 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] arr = new boolean[10000001];
        for (int i=0; i<N; i++) {
            int value = Integer.parseInt(st.nextToken());
            if (arr[value]) {
                System.out.println(value);
                return;
            }
            arr[value] = true;
        }
    }

}
