import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2587 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[5];
        int sum = 0;
        for(int i=0; i<5; i++){
            int value = Integer.parseInt(br.readLine());
            arr[i] = value;
            sum += value;
        }
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        sb.append(sum/5).append('\n').append(arr[2]);
        System.out.print(sb);
    }
}
