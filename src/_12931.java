import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _12931 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 값 별 최적 연산 횟수
        int[] add = new int[N];
        int[] mul = new int[N];
        for (int i=0; i<N; i++) {
            int value = arr[i];
            while (value > 0) {
                if (value % 2 == 0) {
                    value /= 2;
                    mul[i]++;
                }
                else {
                    value--;
                    add[i]++;
                }
            }
//            System.out.printf("%d %d\n", mul[i], add[i]);
        }

        int maxMul = Arrays.stream(mul).max().getAsInt();   // 남는 곱셈은 버림
        int entireAdd = Arrays.stream(add).sum();           // 덧셈은 모두 합함

        System.out.println(maxMul + entireAdd);

    }

}
