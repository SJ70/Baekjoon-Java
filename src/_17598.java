import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _17598 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = 0;
        int t = 0;
        for (int i=0; i<9; i++) {
            switch (br.readLine()) {
                case "Lion" : l++; break;
                case "Tiger" : t++; break;
            }
        }
        System.out.println(l > t ? "Lion" : "Tiger");
    }

}
