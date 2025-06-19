import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16675 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char mL = st.nextToken().charAt(0);
        char mR = st.nextToken().charAt(0);
        char tL = st.nextToken().charAt(0);
        char tR = st.nextToken().charAt(0);

        if (mL == mR && mL == 'S' && (tL == 'R' || tR == 'R')) {
            System.out.println("TK");
            return;
        }
        if (mL == mR && mL == 'P' && (tL == 'S' || tR == 'S')) {
            System.out.println("TK");
            return;
        }
        if (mL == mR && mL == 'R' && (tL == 'P' || tR == 'P')) {
            System.out.println("TK");
            return;
        }
        if (tL == tR && tL == 'S' && (mL == 'R' || mR == 'R')) {
            System.out.println("MS");
            return;
        }
        if (tL == tR && tL == 'P' && (mL == 'S' || mR == 'S')) {
            System.out.println("MS");
            return;
        }
        if (tL == tR && tL == 'R' && (mL == 'P' || mR == 'P')) {
            System.out.println("MS");
            return;
        }

        System.out.println("?");
    }

}
