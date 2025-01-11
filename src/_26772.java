import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _26772 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append(" @@@   @@@  ".repeat(N-1) + " @@@   @@@ \n");
        sb.append("@   @ @   @ ".repeat(N-1) + "@   @ @   @\n");
        sb.append("@    @    @ ".repeat(N-1) + "@    @    @\n");
        sb.append("@         @ ".repeat(N-1) + "@         @\n");
        sb.append(" @       @  ".repeat(N-1) + " @       @ \n");
        sb.append("  @     @   ".repeat(N-1) + "  @     @  \n");
        sb.append("   @   @    ".repeat(N-1) + "   @   @   \n");
        sb.append("    @ @     ".repeat(N-1) + "    @ @    \n");
        sb.append("     @      ".repeat(N-1) + "     @     \n");
        System.out.print(sb);

    }

}
