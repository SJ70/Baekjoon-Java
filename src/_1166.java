import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1166 {

    private static int N;
    private static double L, W, H;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        System.out.println(bs(0, 1000000000));
    }

    private static double bs(double left, double right) {
        for (int i=0; i<60; i++) {
            double mid = (left + right) / 2;
            double midValue = getMaxPutAbleCount(mid);

//            System.out.println(left +"  ~  "+right);
            if (midValue < N) {
                right = mid;
            }
            else { // midValue >= N  :  mid가 답일수도 있음
                left = mid;
            }
        }
        return (left + right) / 2;
    }

    private static double getMaxPutAbleCount(double a) {
        return Math.floor(L/a) * Math.floor(W/a) * Math.floor(H/a);
    }

}
