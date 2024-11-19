import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _29713 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String str = br.readLine();
        int[] arr = new int[10];
        for (char c : str.toCharArray()) {
            switch (c) {
                case 'B' : arr[0]++; break;
                case 'O' : arr[1]++; break;
                case 'N' : arr[2]++; break;
                case 'Z' : arr[3]++; break;
                case 'S' : arr[4]++; break;
                case 'I' : arr[5]++; break;
                case 'L' : arr[6]++; break;
                case 'V' : arr[7]++; break;
                case 'E' : arr[8]++; break;
                case 'R' : arr[9]++; break;
            }
        }
        arr[8] /= 2;
        arr[9] /= 2;
        int result = Arrays.stream(arr).min().getAsInt();
        System.out.println(result);
    }

}
