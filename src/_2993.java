import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _2993 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int length = str.length();

        List<String> results = new ArrayList<>();

        for (int i=0; i<length-2; i++) {
            for (int j=i+1; j<length-1; j++) {
                StringBuilder sb1 = new StringBuilder();
                sb1.append(str, 0, i + 1);
                sb1.reverse();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str, i + 1, j + 1);
                sb2.reverse();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str, j + 1, length);
                sb3.reverse();
                StringBuilder sb = new StringBuilder();
                sb.append(sb1);
                sb.append(sb2);
                sb.append(sb3);
                results.add(sb.toString());
            }
        }

        String result = results.stream().sorted().findFirst().get();
        System.out.println(result);
    }

}
