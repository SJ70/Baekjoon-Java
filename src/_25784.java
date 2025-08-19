import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _25784 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];
        arr[0] = Integer.parseInt(st.nextToken());
        arr[1] = Integer.parseInt(st.nextToken());
        arr[2] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        if (arr[0] + arr[1] == arr[2]) {
            System.out.println(1);
        }
        else if (arr[0] * arr[1] == arr[2]) {
            System.out.println(2);
        }
        else {
            System.out.println(3);
        }
    }

}
