import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1000 {
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        System.out.println(Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken()));
    }
}