import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16103 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        String str = br.readLine();
        String[] split = new String[4];
        for (int i=0; i<4; i++) {
            StringBuilder sb = new StringBuilder();
            int quarterLength = length/4;
            for (int j=0; j<quarterLength; j++) {
                sb.append(str.charAt(i * quarterLength + j));
            }
            split[i] = sb.toString();
        }

        StringBuilder sb = new StringBuilder();
        sb.append(split[0]);

        switch ((int) (k % 3)) {
            case 0 :
                sb.append(split[1]);
                sb.append(split[2]);
                sb.append(split[3]);
                break;
            case 1 :
                sb.append(split[3]);
                sb.append(split[1]);
                sb.append(split[2]);
                break;
            case 2 :
                sb.append(split[2]);
                sb.append(split[3]);
                sb.append(split[1]);
                break;
        }
        System.out.println(sb);

    }

}
