import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _17291 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] birth = new int[N + 1];
        int[] entire = new int[N + 1];
        birth[1] = entire[1] = 1;
        for (int i=2; i<=N; i++) {
            birth[i] = entire[i-1];
            entire[i] = entire[i-1] * 2;
            if (i-3>0 && (i-3)%2==1) {
                entire[i] -= birth[i-3];
            }
            if (i-4>0 && (i-4)%2==0) {
                entire[i] -= birth[i-4];
            }
        }
//        System.out.println(Arrays.toString(birth));
//        System.out.println(Arrays.toString(entire));
        System.out.println(entire[N]);

    }

}
