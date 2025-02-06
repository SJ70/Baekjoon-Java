import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _25270 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a = n;
        int b = n;
        for (int i=0; true; i++, a++, b--){
            if (a%100/10==9 && a%10==9) {
                System.out.println(a);
                return;
            }
            if (b%100/10==9 && b%10==9) {
                System.out.println(b);
                return;
            }
        }
    }

}
