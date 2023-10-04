import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11637 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i=0; i<t; i++) {
            String result = getResult();
            sb.append(result);
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static String getResult() throws IOException {
        int n = Integer.parseInt(br.readLine());

        int tot = 0;
        int maxValueCnt = 0;
        int maxValue = -1;
        int maxValueIndex = -1;

        for (int i=1; i<=n; i++) {
            int value = Integer.parseInt(br.readLine());
            tot += value;

            if (value > maxValue) {
                maxValueCnt = 1;
                maxValue = value;
                maxValueIndex = i;
            }
            else if (value == maxValue) {
                maxValueCnt++;
            }
        }

        if (maxValueCnt > 1) {
            return "no winner";
        }
        else if (maxValue > tot/2) {
            return "majority winner " + maxValueIndex;
        }
        else {
            return "minority winner " + maxValueIndex;
        }

    }

}
