import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _31994 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String resultName = "";
        int maxValue = -1;
        for (int i=0; i<7; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int value = Integer.parseInt(st.nextToken());
            if (value > maxValue) {
                maxValue = value;
                resultName = name;
            }
        }
        System.out.println(resultName);


    }

}
