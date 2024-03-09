import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _31495 {

    public static void main(String[] args) throws IOException {
        String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
        int length = str.length();
        if (str.charAt(0) != '"' || str.charAt(length-1) != '"') {
            System.out.println("CE");
            return;
        }

        StringBuilder sb = new StringBuilder();
        boolean isAllEmpty = true;
        for (int i=1; i<length-1; i++) {
            sb.append(str.charAt(i));
            if (str.charAt(i) != ' ') {
                isAllEmpty = false;
            }
        }
        System.out.println(isAllEmpty ? "CE" : sb);
    }

}
