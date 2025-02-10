import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _33163 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            switch (c) {
                case 'J' : sb.append('O'); break;
                case 'I' : sb.append('J'); break;
                case 'O' : sb.append('I'); break;
            }
        }
        System.out.println(sb);
    }

}
