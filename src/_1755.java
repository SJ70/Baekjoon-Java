import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class _1755 {

    private static List<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        init();
        sort();
        print();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int until = Integer.parseInt(st.nextToken());
        for (int i=from; i<=until; i++) {
            numbers.add(i);
        }
    }

    private static void sort() {
        Collections.sort(numbers, (e1, e2) -> {
            String e1String = getStringValueOfNumbers(e1);
            String e2String = getStringValueOfNumbers(e2);
            return e1String.compareTo(e2String);
        });
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        int length = numbers.size();
        for (int i=1; i<=length; i++) {
            sb.append(numbers.get(i-1));
            sb.append(i%10==0 ? '\n' : ' ');
        }
        System.out.print(sb);
    }

    private static String getStringValueOfNumbers(int number) {
        int ten = number / 10;
        int one = number % 10;

        StringBuilder sb = new StringBuilder();

        if (ten != 0) {
            sb.append(getStringValueOfNumber(ten));
        }
        sb.append(getStringValueOfNumber(one));

        return sb.toString();
    }

    private static String getStringValueOfNumber(int number) {
        switch (number) {
            case 0 : return "zero";
            case 1 : return "one";
            case 2 : return "two";
            case 3 : return "three";
            case 4 : return "four";
            case 5 : return "five";
            case 6 : return "six";
            case 7 : return "seven";
            case 8 : return "eight";
            case 9 : return "nine";
        }
        throw new IllegalArgumentException();
    }
}
