import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _21631 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long white = Long.parseLong(st.nextToken());
        long black = Long.parseLong(st.nextToken());

        System.out.println(Math.min(white+1, black));
    }

}
