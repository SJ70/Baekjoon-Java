import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _1652 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] horizontalStrings = new String[N];
        for (int i=0; i<N; i++) {
            horizontalStrings[i] = br.readLine();
        }

        String[] verticalStrings = new String[N];
        for (int c=0; c<N; c++) {
            StringBuilder sb = new StringBuilder();
            for (int r=0; r<N; r++) {
                sb.append(horizontalStrings[r].charAt(c));
            }
            verticalStrings[c] = sb.toString();
        }

        int horizontalResult = 0;
        int verticalResult = 0;
        for (int i=0; i<N; i++) {
            horizontalResult += Arrays.stream(horizontalStrings[i].split("X")).filter(str -> str.length() > 1).count();
            verticalResult += Arrays.stream(verticalStrings[i].split("X")).filter(str -> str.length() > 1).count();
        }

        System.out.printf("%d %d", horizontalResult, verticalResult);

    }

}
