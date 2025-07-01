import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class _2877 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 2진수는 0부터 시작, 0번째가 1번째
        N--;

//        자리 수 별 수의 개수
//        1자리 2개 (0, 1)
//        2자리 4개 (00, 01, 10, 11)
//        3자리 8개 (000, 001, 010, 011, 100, 101, 110, 111)

        // 몇 자리 수인지 관측
        int length = 1;
        while (true) {
            int numCnt = (int) Math.pow(2, length);
            if (N < numCnt) {
                break;
            }
            N -= numCnt;
            length++;
        }

        // 남은 N으로 2진수 생성
        String bin = Integer.toBinaryString(N);

        // 앞의 빈 자리는 모두 4
        String front = "4".repeat(length - bin.length());

        // 2진수를 가공, 0 -> 4, 1 -> 7
        String back = Arrays.stream(bin.split(""))
                        .map(str -> str.equals("0") ? "4" : "7")
                        .collect(Collectors.joining(""));

        System.out.println(front + back);
    }

}
