import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _21314 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = str.length();

        StringBuilder max = new StringBuilder();
        for (int i=N-1; i>=0; i--) {
            char c = str.charAt(i);
            if (c == 'M') {
                max.append(1);
            }
            else {
                int ms = 0;
                for (int j=i-1; j>=0; j--) {
                    char d = str.charAt(j);
                    if (d == 'M') {
                        ms++;
                        max.append(0);
                    } else {
                        break;
                    }
                }
                max.append(5);
                i -= ms;
            }
        }
        max.reverse();
        System.out.println(max);

        StringBuilder min = new StringBuilder();
        for (int i=0; i<N; i++) {
            char c = str.charAt(i);
            if (c == 'K') {
                min.append(5);
            }
            else {
                min.append(1);
                while (i+1<N && str.charAt(i+1) == 'M') {
                    i++;
                    min.append(0);
                }
            }
        }
        System.out.println(min);

    }

}
