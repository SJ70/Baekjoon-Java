import java.io.*;
import java.util.*;

public class _1309 {

    private static class Cases {
        private final int noLion;
        private final int lionOnLeft;
        private final int lionOnRight;

        public Cases(int noLion, int lionOnLeft, int lionOnRight) {
            this.noLion = noLion % 9901;
            this.lionOnLeft = lionOnLeft % 9901;
            this.lionOnRight = lionOnRight % 9901;
        }

        public Cases getNextCases() {
            int nextNoLion = noLion + lionOnLeft + lionOnRight;
            int nextLionOnLeft = noLion + lionOnRight;
            int nextLionOnRight = noLion + lionOnLeft;
            return new Cases(nextNoLion, nextLionOnLeft, nextLionOnRight);
        }

        public int getEntireCasesCount() {
            return (noLion + lionOnLeft + lionOnRight) % 9901;
        }
    }

    private static int n;
    private static Cases[] cases;

    public static void main(String[] args) throws IOException {
        input();
        dp();
        System.out.println(cases[n-1].getEntireCasesCount());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
    }

    private static void dp() {
        cases = new Cases[n];
        cases[0] = new Cases(1,1,1);

        for (int i=1; i<n; i++) {
            cases[i] = cases[i-1].getNextCases();
        }
    }
}
