import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _32969 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if (str.contains("social")
                || str.contains("history")
                || str.contains("language")
                || str.contains("literacy")) {
            System.out.println("digital humanities");
        }
        if (str.contains("bigdata")
                || str.contains("public")
                || str.contains("society")) {
            System.out.println("public bigdata");
        }
    }

}
