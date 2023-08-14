import java.io.*;

public class _28701 {
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

        int sum1 = 0;
        int sum3 = 0;
        for(int i=1; i<=N; i++){
            sum1 += i;
            sum3 += i*i*i;
        }

        int sum2 = sum1 * sum1;

        System.out.printf("%d\n%d\n%d\n",sum1,sum2,sum3);
    }
}
