import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class _30008 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int studentCount = Integer.parseInt(st.nextToken());

        String[] ranks = br.readLine().split(" ");
        String result = Arrays.stream(ranks)
                .map(Integer::parseInt)
                .map(rank -> getGrade(studentCount, rank))
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.println(result);
    }

    private static int getGrade(int studentCount, int rank) {
        int percentage = rank * 100 / studentCount;
        if (percentage <= 4) {
            return 1;
        }
        else if (percentage <= 11) {
            return 2;
        }
        else if (percentage <= 23) {
            return 3;
        }
        else if (percentage <= 40) {
            return 4;
        }
        else if (percentage <= 60) {
            return 5;
        }
        else if (percentage <= 77) {
            return 6;
        }
        else if (percentage <= 89) {
            return 7;
        }
        else if (percentage <= 96) {
            return 8;
        }
        else {
            return 9;
        }
    }

}
