import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _31636 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        String str = br.readLine();
        System.out.println(str.contains("ooo") ? "Yes" : "No");
    }

}
