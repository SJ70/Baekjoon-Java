import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _25915 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char C = br.readLine().charAt(0);
        int time = 0;
        String str = "ILOVEYONSEI";
        for(int i=0; i<str.length(); i++){
            char next = str.charAt(i);
            time += Math.abs(C-next);
            C = next;
        }
        System.out.println(time);
    }
}
