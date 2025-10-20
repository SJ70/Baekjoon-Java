import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _7771 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[10][10];
        int lastR = 0;
        int lastC = 0;
        for (int r=0; r<10; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c=0; c<10; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
                if (arr[r][c] == 100) {
                    lastR = r;
                    lastC = c;
                }
            }
        }

        boolean[][] isShip = new boolean[10][10];
        int tmpR = (lastR < 5) ? 6 : 0;
        isShip[tmpR][0] = true;
        isShip[tmpR+1][0] = true;
        isShip[tmpR+2][0] = true;
        isShip[tmpR+3][0] = true;
        isShip[tmpR][2] = true;
        isShip[tmpR][3] = true;
        isShip[tmpR][4] = true;
        isShip[tmpR][6] = true;
        isShip[tmpR][7] = true;
        isShip[tmpR][8] = true;
        isShip[tmpR+2][2] = true;
        isShip[tmpR+3][2] = true;
        isShip[tmpR+2][4] = true;
        isShip[tmpR+3][4] = true;
        isShip[tmpR+2][6] = true;
        isShip[tmpR+3][6] = true;
        isShip[tmpR+2][8] = true;

        int tmpC = (lastC < 5) ? 6 : 0;
        isShip[lastR][tmpC] = true;
        isShip[lastR][tmpC + 2] = true;

        isShip[lastR][lastC] = true;

        StringBuilder sb = new StringBuilder();
        for (int r=0; r<10; r++) {
            for (int c=0; c<10; c++) {
                sb.append(isShip[r][c] ? '#' : '.');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

}
