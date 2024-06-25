import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _30032 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        String[] arr = new String[N];
        for (int r=0; r<N; r++) {
            arr[r] = br.readLine();
        }

        StringBuilder sb = new StringBuilder();
        for (int r=0; r<N; r++) {
            for (int c=0; c<N; c++) {
                char value = arr[r].charAt(c);
                if (dir == 1) {
                    switch (value) {
                        case 'q' : sb.append('d'); break;
                        case 'p' : sb.append('b'); break;
                        case 'b' : sb.append('p'); break;
                        case 'd' : sb.append('q'); break;
                    }
                }
                else {
                    switch (value) {
                        case 'q' : sb.append('p'); break;
                        case 'p' : sb.append('q'); break;
                        case 'b' : sb.append('d'); break;
                        case 'd' : sb.append('b'); break;
                    }
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);

    }

}
