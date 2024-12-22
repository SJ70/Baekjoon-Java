import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _32684 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = {13, 7, 5, 3, 3, 2};
        int[] arrA = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arrB = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int scoreA = 0;
        int scoreB = 1;
        for (int i=0; i<6; i++) {
            scoreA += arr[i] * arrA[i];
            scoreB += arr[i] * arrB[i];
        }
        System.out.println(scoreA > scoreB ? "cocjr0208" : "ekwoo");
    }

}
