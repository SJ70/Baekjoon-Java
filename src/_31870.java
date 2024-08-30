import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _31870 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] desc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] asc = desc.clone();

        int descCnt = 0;
        boolean descChanged = true;
        while (descChanged) {
            descChanged = false;
            for (int i=0; i<N-1; i++) {
                if (desc[i] > desc[i+1]) {
                    int tmp = desc[i];
                    desc[i] = desc[i+1];
                    desc[i+1] = tmp;
                    descCnt++;
                    descChanged = true;
                }
            }
        }

        int ascCnt = 1;
        boolean ascChanged = true;
        while (ascChanged) {
            ascChanged = false;
            for (int i=0; i<N-1; i++) {
                if (asc[i] < asc[i+1]) {
                    int tmp = asc[i];
                    asc[i] = asc[i+1];
                    asc[i+1] = tmp;
                    ascCnt++;
                    ascChanged = true;
                }
            }
        }

        System.out.println(Math.min(descCnt, ascCnt));

    }

}
