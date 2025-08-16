import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _26742 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int b = 0;
        int c = 0;
        for (char ch : str.toCharArray()) {
            switch (ch) {
                case 'B': b++; break;
                case 'C': c++; break;
            }
        }
        System.out.println(b/2 + c/2);
    }

}
