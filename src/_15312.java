import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _15312 {

    public static void main(String[] args) throws IOException {
        int[] values = new int[] {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();

        int length = A.length();
        int[] arr = new int[length * 2];
        for (int i=0; i<length; i++) {
            arr[i * 2] = values[A.charAt(i) - 'A'];
            arr[i * 2 + 1] = values[B.charAt(i) - 'A'];
        }

        while (arr.length > 2) {
            arr = getNextArr(arr);
        }

        System.out.printf("%d%d\n", arr[0], arr[1]);
    }

    private static int[] getNextArr(int[] arr) {
        int[] newArr = new int[arr.length - 1];
        for (int i = 0; i < arr.length - 1; i++) {
            newArr[i] = (arr[i] + arr[i + 1]) % 10;
        }
        return newArr;
    }

}
