import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2477 {

    private static final int[] DX = new int[] {0, 1, 0,-1};
    private static final int[] DY = new int[] {1, 0,-1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int multiplier = Integer.parseInt(br.readLine());

        int[][] inputs = new int[6][2];

        for (int i=0; i<6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            inputs[i][0] = Integer.parseInt(st.nextToken()) - 1;
            inputs[i][1] = Integer.parseInt(st.nextToken());
        }

        boolean[] bigSquareDir = new boolean[4];
        for (int[] input : inputs) {
            bigSquareDir[input[0]] = !bigSquareDir[input[0]];
        }

        int bigSquareArea = 1;
        for (int[] input : inputs) {
            if (bigSquareDir[input[0]]) {
                bigSquareArea *= input[1];
            }
        }

        int smallSquareArea = 1;
        for (int i=0; i<6; i++) {
            if ((bigSquareDir[inputs[(i-2+6)%6][0]] && !bigSquareDir[inputs[(i-1+6)%6][0]]) || (!bigSquareDir[inputs[(i+1)%6][0]] && bigSquareDir[inputs[(i+2)%6][0]])) {
                smallSquareArea *= inputs[i][1];
            }
        }

        System.out.println(multiplier * (bigSquareArea - smallSquareArea));

    }

}