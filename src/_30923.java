import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Stack;
import java.util.StringTokenizer;

public class _30923 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static Stack<Long> stack = new Stack<>();
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            long value = Long.parseLong(st.nextToken());
            if (!stack.isEmpty()) {
                result -= Math.min(stack.peek(), value) * 2;
            }
            stack.push(value);
        }

        BigInteger sum = new BigInteger(String.valueOf(stack.stream().mapToLong(Long::valueOf).sum()));
        BigInteger multiplied = sum.multiply(new BigInteger("4"));
        BigInteger tmp = new BigInteger(String.valueOf(n)).multiply(new BigInteger("2"));
        BigInteger bigResult = new BigInteger(String.valueOf(result)).add(multiplied).add(tmp);

        System.out.println(bigResult);
    }
}
