import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _20540 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0) == 'I' ? 'E' : 'I');
        sb.append(str.charAt(1) == 'S' ? 'N' : 'S');
        sb.append(str.charAt(2) == 'T' ? 'F' : 'T');
        sb.append(str.charAt(3) == 'J' ? 'P' : 'J');
        System.out.println(sb);
    }

}
