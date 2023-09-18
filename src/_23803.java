import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _23803 {
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n*4; i++){
            sb.append("@".repeat(n)).append('\n');
        }

        for(int i=0; i<n; i++){
            sb.append("@".repeat(n*5)).append('\n');
        }

        sb.deleteCharAt(sb.length()-1);

        System.out.print(sb);
    }
}
