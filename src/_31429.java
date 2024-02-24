import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _31429 {

    public static void main(String[] args) throws IOException {

        int rank = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int idx = rank - 1;

        int[] cnt = new int[]{12, 11, 11, 10, 9, 9, 9, 8, 7, 6, 6};
        int[] min = new int[]{1600, 894, 1327, 1311, 1004, 1178, 1357, 837, 1055, 556, 773};

        System.out.printf("%d %d\n", cnt[idx], min[idx]);

    }

}
