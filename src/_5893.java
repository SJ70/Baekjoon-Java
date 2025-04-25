import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5893 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int[] arr = new int[str.length() + 4];
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == '1') {
                arr[i]++;
                arr[i + 4]++;
            }
        }

        for (int i=arr.length-1; i>0; i--) {
            if (arr[i] > 1) {
                arr[i] -= 2;
                arr[i-1]++;
            }
        }
        if (arr[0] > 1) {
            System.out.print(1);
            arr[0] -= 2;
        }
        for (int value : arr) {
            System.out.print(value);
        }
        System.out.println();
    }

}
