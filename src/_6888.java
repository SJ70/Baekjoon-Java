import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _6888 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=a; i<=b; i+=60) {
            String str = String.format("All positions change in year %d\n", i);
            sb.append(str);
        }
        System.out.print(sb);
    }

}
