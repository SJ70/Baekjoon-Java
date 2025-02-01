import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _26736 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int a = 0;
        int b = 0;
        for (char c : str.toCharArray()) {
            switch (c) {
                case 'A' : a++; break;
                case 'B' : b++; break;
            }
        }
        System.out.printf("%d : %d\n", a, b);
    }

}
