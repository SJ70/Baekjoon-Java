import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _29340 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> arr = new ArrayList<>();
        for (char c : br.readLine().toCharArray()) {
            int value = c - '0';
            arr.add(value);
        }
        String next = br.readLine();
        for (int i=0; i<arr.size(); i++) {
            arr.set(i, Math.max(arr.get(i), next.charAt(i) - '0'));
        }
        for (int value : arr) {
            System.out.print(value);
        }
    }

}
