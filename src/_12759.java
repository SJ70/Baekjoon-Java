import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _12759 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[][] arr = new Integer[3][3];
        for (int i=0; i<9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int value = i % 2;
            arr[x][y] = value;
            if ((arr[0][0] != null && arr[0][0] == arr[0][1] && arr[0][0] == arr[0][2])
                    || (arr[1][0] != null && arr[1][0] == arr[1][1] && arr[1][0] == arr[1][2])
                    || (arr[2][0] != null && arr[2][0] == arr[2][1] && arr[2][0] == arr[2][2])
                    || (arr[0][0] != null && arr[0][0] == arr[1][0] && arr[0][0] == arr[2][0])
                    || (arr[0][1] != null && arr[0][1] == arr[1][1] && arr[0][1] == arr[2][1])
                    || (arr[0][2] != null && arr[0][2] == arr[1][2] && arr[0][2] == arr[2][2])
                    || (arr[0][0] != null && arr[0][0] == arr[1][1] && arr[0][0] == arr[2][2])
                    || (arr[0][2] != null && arr[0][2] == arr[1][1] && arr[0][2] == arr[2][0])) {
                System.out.println(value == 0 ? N : 3 - N);
                return;
            }
        }
        System.out.println(0);
    }

}
