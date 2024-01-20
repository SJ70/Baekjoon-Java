import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class _3460 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i=0; i<t; i++) {
            int num = Integer.parseInt(br.readLine());
            String binaryString = Integer.toBinaryString(num);
            int length = binaryString.length();
            List<Integer> posIsOne = new ArrayList<>();
            for (int j = 0; j < length; j++) {
                if (binaryString.charAt(length - 1 - j) == '1') {
                    posIsOne.add(j);
                }
            }
            sb.append(posIsOne.stream().map(String::valueOf).collect(Collectors.joining(" ")));
            sb.append('\n');
        }

        System.out.print(sb);
    }

}
