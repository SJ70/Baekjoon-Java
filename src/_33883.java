import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class _33883 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char last = str.charAt(str.length()-1);
        if (List.of('a', 'e', 'i', 'o', 'u', 'n', 's').contains(last)) {
            int tmp = 0;
            for (int i=str.length()-1; i>=0; i--) {
                if (List.of('a', 'e', 'i', 'o', 'u').contains(str.charAt(i))) {
                    tmp++;
                    if (tmp == 2) {
                        System.out.println(i + 1);
                        return;
                    }
                }
            }
        }
        else {
            for (int i=str.length()-1; i>=0; i--) {
                if (List.of('a', 'e', 'i', 'o', 'u').contains(str.charAt(i))) {
                    System.out.println(i + 1);
                    return;
                }
            }
        }
        System.out.println(-1);
    }

}
