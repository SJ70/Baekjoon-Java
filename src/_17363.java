import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17363 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        String[] values = new String[R];
        for (int r=0; r<R; r++) {
            values[r] = br.readLine();
        }
        StringBuilder sb = new StringBuilder();
        for (int c=C-1; c>=0; c--) {
            for (int r=0; r<R; r++) {
                char value = values[r].charAt(c);
                switch (value) {
                    case '-': value = '|'; break;
                    case '|': value = '-'; break;
                    case '/': value = '\\'; break;
                    case '\\': value = '/'; break;
                    case '^': value = '<'; break;
                    case '<': value = 'v'; break;
                    case 'v': value = '>'; break;
                    case '>': value = '^'; break;
                }
                sb.append(value);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

}
