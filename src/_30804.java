import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class _30804 {

    private static int[] numbers = IntStream.generate(() -> 0).limit(9).toArray();
    private static int usedKinds = 0;

    private static int n;
    private static int[] values;

    public static void main(String[] args) throws IOException {
        input();

        int maxLength = 1;

        // 투포인터
        int left = 0;
        int right = 0;
        addNumber(values[0]);
//        printNumbers();

        while (true) {
            if (usedKinds <= 2) {
                int length = right - left + 1;
                maxLength = Math.max(length, maxLength);

                right++;
                if (right == n) {
                    break;
                }
                addNumber(values[right]);
            }
            if (usedKinds > 2) {
                delNumber(values[left]);
                left++;
            }
//            printNumbers();
        }

        System.out.println(maxLength);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        values = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            values[i] = Integer.parseInt(st.nextToken()) - 1;
        }
    }

    private static void addNumber(int number) {
        if (numbers[number] == 0) {
            usedKinds++;
        }
        numbers[number]++;
    }

    private static void delNumber(int number) {
        numbers[number]--;
        if (numbers[number] == 0) {
            usedKinds--;
        }
    }

//    private static void printNumbers() {
//        for (int number : numbers) {
//            System.out.printf("%3d", number);
//        }
//        System.out.println();
//    }

}
