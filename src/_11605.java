import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11605 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] operations = new String[N][2];
        for (int i=0; i<N; i++) {
            operations[i] = br.readLine().split(" ");
        }

        int result = 0;
        loop: for (int i=1; i<=100; i++) {
            int value = i;
            for (String[] operation : operations) {
                int tmp = Integer.parseInt(operation[1]);
                switch (operation[0]) {
                    case "ADD" :
                        value += tmp;
                        break;
                    case "SUBTRACT" :
                        value -= tmp;
                        if (value < 0) {
                            result++;
                            continue loop;
                        }
                        break;
                    case "MULTIPLY" :
                        value *= tmp;
                        break;
                    case "DIVIDE" :
                        if (value % tmp > 0) {
                            result++;
                            continue loop;
                        }
                        value /= tmp;
                        break;
                }
            }
        }
        System.out.println(result);

    }

}
