import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _30412 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] heights = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int minResult = Integer.MAX_VALUE;

        // 좌측 끝
        minResult = Math.min(
                X - Math.abs(heights[0] - heights[1]),
                minResult
        );

        // 우측 끝
        minResult = Math.min(
                X - Math.abs(heights[N-1] - heights[N-2]),
                minResult
        );

        for (int i=1; i<N-1; i++) {
            int l = heights[i-1];
            int m = heights[i];
            int r = heights[i+1];

            if (l<m && m>r) {  // case: ^
                minResult = Math.min(
                        X - Math.min(m-l, m-r),
                        minResult
                );
            }
            else if (l<=m && m>=r) {     // case: ――, ￣＼, ／￣
                minResult = Math.min(X, minResult);
            }
            else if (l>=m && m<=r) {     // case: v, ＿／, ＼＿
                int left = Math.max(0, X-(l-m));
                int right = Math.max(0, X-(r-m));
                minResult = Math.min(left + right, minResult);
            }
            else if (l<m && m<r) {  // case: ／
                int left = Math.max(0, X-(m-l));
                int mTmp = m + left;
                int right = Math.max(0, X-(r-mTmp));
                minResult = Math.min(
                        left + right,
                        minResult
                );
            }
            else if (l>m && m>r) {  // case: ＼
                int right = Math.max(0, X-(m-r));
                int mTmp = m + right;
                int left = Math.max(0, X-(l-mTmp));
                minResult = Math.min(
                        left + right,
                        minResult
                );
            }

        }

        minResult = Math.max(0, minResult);
        System.out.println(minResult);
    }

}
