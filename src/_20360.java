import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class _20360 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = Integer.toBinaryString(N);
        List<Integer> result = new ArrayList<>();
        for (int i=str.length()-1; i>=0; i--) {
            if (str.charAt(i) == '1') {
                result.add(str.length() - 1 - i);
            }
        }
        System.out.println(result.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }

}
