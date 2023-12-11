import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _30917 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int a = getValue('A');
        int b = getValue('B');
        System.out.printf("! %d\n", a + b);
    }

    private static int getValue(char name) throws IOException {
        for (int i=1; i<=9; i++) {
            System.out.printf("? %c %d\n", name, i);
            if (br.readLine().equals("1")) {
                return i;
            }
        }
        throw new IllegalArgumentException();
    }

}
