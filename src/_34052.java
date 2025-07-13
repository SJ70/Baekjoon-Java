import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _34052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int timeLimit = 1800;
        for (int i=0; i<4; i++) {
            int value = Integer.parseInt(br.readLine());
            timeLimit -= value;
        }
        System.out.println(timeLimit >= 300 ? "Yes" : "No");
    }

}
