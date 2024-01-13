import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _29725 {

    private static int whiteScore, blackScore;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int r=0; r<8; r++) {
            String str = br.readLine();
            for (int c=0; c<8; c++) {
                char character = str.charAt(c);
                addScore(character);
            }
        }
        System.out.println(whiteScore - blackScore);
    }

    private static void addScore(char c) {
        switch (c) {
            case 'K' : whiteScore += 0; break;
            case 'k' : blackScore += 0; break;
            case 'P' : whiteScore += 1; break;
            case 'p' : blackScore += 1; break;
            case 'N' : whiteScore += 3; break;
            case 'n' : blackScore += 3; break;
            case 'B' : whiteScore += 3; break;
            case 'b' : blackScore += 3; break;
            case 'R' : whiteScore += 5; break;
            case 'r' : blackScore += 5; break;
            case 'Q' : whiteScore += 9; break;
            case 'q' : blackScore += 9; break;
        }
    }

}
