import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _21665 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        String[] arr = new String[R];
        for (int r=0; r<R; r++) {
            arr[r] = br.readLine();
        }
        br.readLine();
        int diff = 0;
        for (int r=0; r<R; r++) {
            String str = br.readLine();
            for (int c=0; c<C; c++) {
                if (arr[r].charAt(c) == str.charAt(c)) {
                    diff++;
                }
            }
        }
        System.out.println(diff);
    }

}
