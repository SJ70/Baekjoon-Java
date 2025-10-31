import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _34455 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            char operator = br.readLine().charAt(0);
            int value = Integer.parseInt(br.readLine());
            switch (operator) {
                case '+':
                    result += value;
                    break;
                case '-':
                    result -= value;
                    break;
            }
        }
        System.out.println(result);
    }

}
