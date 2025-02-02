import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5789 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            String str = br.readLine();
            int mid = str.length() / 2;
            boolean bool = str.charAt(mid) == str.charAt(mid - 1);
            sb.append(bool ? "Do-it\n" : "Do-it-Not\n");
        }
        System.out.print(sb);
    }

}
