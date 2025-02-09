import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _31009 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] arr = new String[N][2];
        int value = 0;
        for (int i=0; i<N; i++) {
            arr[i] = br.readLine().split(" ");
            if (arr[i][0].equals("jinju")) {
                value = Integer.parseInt(arr[i][1]);
            }
        }
        int result = 0;
        for (String[] a : arr) {
            if (value < Integer.parseInt(a[1])) {
                result++;
            }
        }
        System.out.println(value);
        System.out.println(result);
    }

}
