import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _3449 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            String a = br.readLine();
            String b = br.readLine();
            int length = a.length();
            int diff = 0;
            for (int j=0; j<length; j++) {
                if (a.charAt(j) != b.charAt(j)) {
                    diff++;
                }
            }
            sb.append(String.format("Hamming distance is %d.\n", diff));
        }
        System.out.print(sb);
    }

}
