import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _11656 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int length = str.length();
        String[] arr = new String[length];
        for (int i=0; i<length; i++) {
            arr[i] = str.substring(i);
        }
        Arrays.sort(arr);
        System.out.println(String.join("\n", arr));
    }

}
