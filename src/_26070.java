import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _26070 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] gom = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
        long[] sik = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

        long result = 0;

        for (int i=0; i<3; i++) {
            long tmp = Math.min(gom[i], sik[i]);
            tmp = Math.max(tmp, 0);
            gom[i] -= tmp;
            sik[i] -= tmp;
            result += tmp;
        }

        for (int i=0; i<3; i++) {
            long tmp = Math.min(gom[(i+1)%3], sik[i]/3);
            tmp = Math.max(tmp, 0);
            gom[(i+1)%3] -= tmp;
            sik[i] -= tmp * 3;
            result += tmp;
        }

        for (int i=0; i<3; i++) {
            long tmp = Math.min(gom[(i+2)%3], sik[i]/9);
            tmp = Math.max(tmp, 0);
            gom[(i+2)%3] -= tmp;
            sik[i] -= tmp * 9;
            result += tmp;
        }

        System.out.println(result);
    }

}
