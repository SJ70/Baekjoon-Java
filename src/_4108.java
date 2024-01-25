import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _4108 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (r + c == 0) {
                break;
            }
            char[][] arr = new char[r][c];
            for (int i=0; i<r; i++) {
                arr[i] = br.readLine().toCharArray();
            }
            for (int i=0; i<r; i++) {
                for (int j=0; j<c; j++) {
                    if (arr[i][j] != '*') {
                        arr[i][j] = '0';
                        for (int k=i-1; k<=i+1; k++) {
                            if (k < 0 || k == r) {
                                continue;
                            }
                            for (int l=j-1; l<=j+1; l++) {
                                if (l < 0 || l == c) {
                                    continue;
                                }
                                if (arr[k][l] == '*') {
                                    arr[i][j]++;
                                }
                            }
                        }
                    }
                    sb.append(arr[i][j]);
                }
                sb.append('\n');
            }

        }

        System.out.print(sb);

    }
}
