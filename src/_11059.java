import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _11059 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        int[] prefixSum = new int[arr.length + 1];
        for (int i=0; i<arr.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }
        for (int i=arr.length/2*2; i>=1; i-=2) {
            for (int j=0; i+j<=arr.length; j++) {
                if (prefixSum[j+i] - prefixSum[j+i/2] == prefixSum[j+i/2] - prefixSum[j]) {
                    System.out.println(i);
                    return;
                }
            }
        }
    }

}
