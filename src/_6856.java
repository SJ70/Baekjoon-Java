import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _6856 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i=Math.min(A, 9); i>=1; i--) {
            if (10 - i <= B) {
                result++;
            }
            else {
                break;
            }
        }
        if (result == 1) {
            System.out.println("There is 1 way to get the sum 10.");
        }
        else {
            System.out.printf("There are %d ways to get the sum 10.\n", result);
        }

    }

}
