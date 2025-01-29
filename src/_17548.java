import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _17548 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        sb.append('h');
        sb.append("e".repeat((str.length() - 2) * 2));
        sb.append('y');
        System.out.println(sb);
    }

}
