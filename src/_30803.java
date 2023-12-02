import java.io.*;
import java.util.*;

public class _30803 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    private static int n;
    private static long[] values;
    private static boolean[] isClosed;
    private static long entireValue;

    public static void main(String[] args) throws IOException {

        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        values = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            values[i] = Long.parseLong(st.nextToken());
            entireValue += values[i];
        }
        isClosed = new boolean[n];

        int m = Integer.parseInt(br.readLine());

        sb.append(entireValue).append('\n');

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken()) - 1;
            switch (command) {
                case 1:
                    long preValue = values[index];
                    long nextValue = Integer.parseInt(st.nextToken());
                    long diff = nextValue - preValue;
                    if (!isClosed[index]) {
                        entireValue += diff;
                    }

                    values[index] = nextValue;
                    break;
                case 2:
                    isClosed[index] = !isClosed[index];
                    if (!isClosed[index]) {
                        entireValue += values[index];
                    }
                    if (isClosed[index]) {
                        entireValue -= values[index];
                    }
                    break;
            }

            sb.append(entireValue).append('\n');
        }
        System.out.print(sb);
    }

}
