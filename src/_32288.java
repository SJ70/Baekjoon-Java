import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _32288 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (char c : br.readLine().toCharArray()) {
            switch (c) {
                case 'l' : sb.append('L'); break;
                case 'I' : sb.append('i'); break;
            }
        }
        System.out.println(sb);
    }

}
