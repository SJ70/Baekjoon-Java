import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _24053 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] goal = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        boolean[] same = new boolean[N];
        int sameCnt = 0;
        for (int i=0; i<N; i++) {
            if (arr[i] == goal[i]) {
                same[i] = true;
                sameCnt++;
            }
        }
        if (sameCnt == N) {
            System.out.println(1);
            return;
        }

        for (int i=1; i<N; i++) {
            int value = arr[i];
            int j=i-1;
            while (arr[j] > value) {
                arr[j+1] = arr[j];
                if (arr[j+1] == goal[j+1]) {
                    same[j+1] = true;
                    sameCnt++;
                    if (sameCnt == N) {
                        System.out.println(1);
                        return;
                    }
                }
                else if (same[j+1]) {
                    same[j+1] = false;
                    sameCnt--;
                }

                j--;
                if (j < 0) {
                    break;
                }
            }
            arr[j+1] = value;
            if (arr[j+1] == goal[j+1]) {
                same[j+1] = true;
                sameCnt++;
                if (sameCnt == N) {
                    System.out.println(1);
                    return;
                }
            }
            else if (same[j+1]) {
                same[j+1] = false;
                sameCnt--;
            }
        }
        System.out.println(0);

    }

}
