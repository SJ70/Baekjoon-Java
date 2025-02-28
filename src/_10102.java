import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10102 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int result = 0;
        for (char c : str.toCharArray()) {
            result += c == 'A' ? 1 : -1;
        }
        System.out.println(result == 0 ? "Tie" : result > 0 ? "A" : "B");
    }

}
