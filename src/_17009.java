import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _17009 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int apple = getScore();
        int banana = getScore();
        System.out.println(apple == banana ? 'T' : apple > banana ? 'A' : 'B');
    }

    private static int getScore() throws IOException {
        return Integer.parseInt(br.readLine()) * 3
                + Integer.parseInt(br.readLine()) * 2
                + Integer.parseInt(br.readLine());
    }

}
