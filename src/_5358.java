import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5358 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = "";
        while ((input = br.readLine()) != null) {
            for (char c : input.toCharArray()) {
                switch (c) {
                    case 'i' : sb.append('e'); break;
                    case 'e' : sb.append('i'); break;
                    case 'I' : sb.append('E'); break;
                    case 'E' : sb.append('I'); break;
                    default  : sb.append(c); break;
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

}
