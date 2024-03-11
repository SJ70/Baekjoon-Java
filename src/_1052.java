import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class _1052 {

    private static final int LENGTH = 30;
    private static int N, K;
    private static int[] binaryValue = new int[LENGTH];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N <= K) {
            System.out.println(0);
            return;
        }

        String binaryN = Integer.toBinaryString(N);
        Arrays.fill(binaryValue, 0);
        int binaryNLength = binaryN.length();
        for (int i=0; i<binaryNLength; i++) {
            binaryValue[LENGTH - binaryNLength + i] = binaryN.charAt(i) - '0';
        }

        if (countOne(binaryValue) <= K) {
            System.out.println(0);
            return;
        }

//        System.out.println(Arrays.stream(binaryValue).mapToObj(String::valueOf).collect(Collectors.joining()));
        subtractOne();
//        System.out.println(Arrays.stream(binaryValue).mapToObj(String::valueOf).collect(Collectors.joining()));
        System.out.println(getDiff());

    }

    private static int countOne(int[] binaryValue) {
        int result = 0;
        for (int value : binaryValue) {
            result += value;
        }
        return result;
    }

    private static void subtractOne() {
        int oneCnt = countOne(binaryValue);
        int i = LENGTH - 1;
        while (oneCnt > K) {
//            System.out.println(Arrays.stream(binaryValue).mapToObj(String::valueOf).collect(Collectors.joining()) + ", " + oneCnt);
            if (binaryValue[i] == 1) {
                binaryValue[i] = 0;
                binaryValue[i-1]++;
                for (int j=i-1; binaryValue[j] == 2; j--) {
                    binaryValue[j] = 0;
                    binaryValue[j-1]++;
                    oneCnt--;
                }
            }
            i--;
        }
    }

    private static int getDiff() {
        StringBuilder sb = new StringBuilder();
        for (int e : binaryValue) {
            sb.append(e);
        }
        return Integer.parseInt(sb.toString(), 2) - N;
    }

}
