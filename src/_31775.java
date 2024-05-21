import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _31775 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = new String[3];
        for (int i=0; i<3; i++) {
            strs[i] = br.readLine();
        }
        Arrays.sort(strs);

        System.out.println(strs[0].charAt(0)=='k' && strs[1].charAt(0)=='l' && strs[2].charAt(0)=='p' ? "GLOBAL" : "PONIX");

    }

}
