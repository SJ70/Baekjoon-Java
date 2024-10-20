import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _9047 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            int value = Integer.parseInt(br.readLine());
            for (int i=0; true; i++) {
                if (value == 6174) {
                    sb.append(i);
                    sb.append('\n');
                    break;
                }
                value = fn(value);
            }
        }
        System.out.print(sb);
    }

    private static int fn(int value) {
        char[] arr = String.format("%04d", value).toCharArray();
        Arrays.sort(arr);
        int smallest = Integer.parseInt("" + arr[0] + arr[1] + arr[2] + arr[3]);
        int largest = Integer.parseInt("" + arr[3] + arr[2] + arr[1] + arr[0]);
        return largest - smallest;
    }

}
