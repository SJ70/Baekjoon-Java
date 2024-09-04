import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _25893 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t=0; t<T; t++) {
            int overTenCnt = 0;
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            for (int i=0; i<3; i++) {
                int value = Integer.parseInt(st.nextToken());
                if (value >= 10) {
                    overTenCnt++;
                }
            }
            sb.append(input);
            sb.append('\n');
            switch (overTenCnt) {
                case 0 : sb.append("zilch"); break;
                case 1 : sb.append("double"); break;
                case 2 : sb.append("double-double"); break;
                case 3 : sb.append("triple-double"); break;
            }
            sb.append(t == T-1 ? "\n" : "\n\n");
        }
        System.out.print(sb);
    }

}
