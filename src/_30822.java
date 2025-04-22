import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _30822 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        int[] arr = new int[26];
        for (char c : br.readLine().toCharArray()) {
            arr[c - 'a']++;
        }
        System.out.println(Math.min(Math.min(Math.min(Math.min(arr['u'-'a'], arr['o'-'a']), arr['s'-'a']), arr['p'-'a']), arr['c'-'a']));
    }

}
